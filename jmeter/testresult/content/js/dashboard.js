/*
   Licensed to the Apache Software Foundation (ASF) under one or more
   contributor license agreements.  See the NOTICE file distributed with
   this work for additional information regarding copyright ownership.
   The ASF licenses this file to You under the Apache License, Version 2.0
   (the "License"); you may not use this file except in compliance with
   the License.  You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
*/
var showControllersOnly = false;
var seriesFilter = "";
var filtersOnlySampleSeries = true;

/*
 * Add header in statistics table to group metrics by category
 * format
 *
 */
function summaryTableHeader(header) {
    var newRow = header.insertRow(-1);
    newRow.className = "tablesorter-no-sort";
    var cell = document.createElement('th');
    cell.setAttribute("data-sorter", false);
    cell.colSpan = 1;
    cell.innerHTML = "Requests";
    newRow.appendChild(cell);

    cell = document.createElement('th');
    cell.setAttribute("data-sorter", false);
    cell.colSpan = 3;
    cell.innerHTML = "Executions";
    newRow.appendChild(cell);

    cell = document.createElement('th');
    cell.setAttribute("data-sorter", false);
    cell.colSpan = 6;
    cell.innerHTML = "Response Times (ms)";
    newRow.appendChild(cell);

    cell = document.createElement('th');
    cell.setAttribute("data-sorter", false);
    cell.colSpan = 1;
    cell.innerHTML = "Throughput";
    newRow.appendChild(cell);

    cell = document.createElement('th');
    cell.setAttribute("data-sorter", false);
    cell.colSpan = 2;
    cell.innerHTML = "Network (KB/sec)";
    newRow.appendChild(cell);
}

/*
 * Populates the table identified by id parameter with the specified data and
 * format
 *
 */
function createTable(table, info, formatter, defaultSorts, seriesIndex, headerCreator) {
    var tableRef = table[0];

    // Create header and populate it with data.titles array
    var header = tableRef.createTHead();

    // Call callback is available
    if(headerCreator) {
        headerCreator(header);
    }

    var newRow = header.insertRow(-1);
    for (var index = 0; index < info.titles.length; index++) {
        var cell = document.createElement('th');
        cell.innerHTML = info.titles[index];
        newRow.appendChild(cell);
    }

    var tBody;

    // Create overall body if defined
    if(info.overall){
        tBody = document.createElement('tbody');
        tBody.className = "tablesorter-no-sort";
        tableRef.appendChild(tBody);
        var newRow = tBody.insertRow(-1);
        var data = info.overall.data;
        for(var index=0;index < data.length; index++){
            var cell = newRow.insertCell(-1);
            cell.innerHTML = formatter ? formatter(index, data[index]): data[index];
        }
    }

    // Create regular body
    tBody = document.createElement('tbody');
    tableRef.appendChild(tBody);

    var regexp;
    if(seriesFilter) {
        regexp = new RegExp(seriesFilter, 'i');
    }
    // Populate body with data.items array
    for(var index=0; index < info.items.length; index++){
        var item = info.items[index];
        if((!regexp || filtersOnlySampleSeries && !info.supportsControllersDiscrimination || regexp.test(item.data[seriesIndex]))
                &&
                (!showControllersOnly || !info.supportsControllersDiscrimination || item.isController)){
            if(item.data.length > 0) {
                var newRow = tBody.insertRow(-1);
                for(var col=0; col < item.data.length; col++){
                    var cell = newRow.insertCell(-1);
                    cell.innerHTML = formatter ? formatter(col, item.data[col]) : item.data[col];
                }
            }
        }
    }

    // Add support of columns sort
    table.tablesorter({sortList : defaultSorts});
}

$(document).ready(function() {

    // Customize table sorter default options
    $.extend( $.tablesorter.defaults, {
        theme: 'blue',
        cssInfoBlock: "tablesorter-no-sort",
        widthFixed: true,
        widgets: ['zebra']
    });

    var data = {"OkPercent": 100.0, "KoPercent": 0.0};
    var dataset = [
        {
            "label" : "KO",
            "data" : data.KoPercent,
            "color" : "#FF6347"
        },
        {
            "label" : "OK",
            "data" : data.OkPercent,
            "color" : "#9ACD32"
        }];
    $.plot($("#flot-requests-summary"), dataset, {
        series : {
            pie : {
                show : true,
                radius : 1,
                label : {
                    show : true,
                    radius : 3 / 4,
                    formatter : function(label, series) {
                        return '<div style="font-size:8pt;text-align:center;padding:2px;color:white;">'
                            + label
                            + '<br/>'
                            + Math.round10(series.percent, -2)
                            + '%</div>';
                    },
                    background : {
                        opacity : 0.5,
                        color : '#000'
                    }
                }
            }
        },
        legend : {
            show : true
        }
    });

    // Creates APDEX table
    createTable($("#apdexTable"), {"supportsControllersDiscrimination": true, "overall": {"data": [0.9995659523809524, 500, 1500, "Total"], "isController": false}, "titles": ["Apdex", "T (Toleration threshold)", "F (Frustration threshold)", "Label"], "items": [{"data": [0.99945, 500, 1500, "\/isu\/users\/students-262"], "isController": false}, {"data": [0.999225, 500, 1500, "\/isu\/literature\/-264"], "isController": false}, {"data": [0.99953, 500, 1500, "\/isu\/-259-1"], "isController": false}, {"data": [0.99987, 500, 1500, "\/isu\/users\/teachers-263-0"], "isController": false}, {"data": [0.99962, 500, 1500, "\/isu\/users\/teachers-263-1"], "isController": false}, {"data": [0.999505, 500, 1500, "\/isu\/literature\/-264-1"], "isController": false}, {"data": [0.999485, 500, 1500, "\/isu\/users\/teachers-263"], "isController": false}, {"data": [0.999775, 500, 1500, "\/isu\/-259-0"], "isController": false}, {"data": [0.999725, 500, 1500, "\/isu\/literature\/-264-0"], "isController": false}, {"data": [0.99976, 500, 1500, "\/isu\/my_group-260-0"], "isController": false}, {"data": [0.999305, 500, 1500, "\/isu\/-259"], "isController": false}, {"data": [0.99961, 500, 1500, "\/isu\/my_group-260-1"], "isController": false}, {"data": [0.999635, 500, 1500, "\/isu\/users\/students-262-1"], "isController": false}, {"data": [0.99973, 500, 1500, "\/isu\/-265-0"], "isController": false}, {"data": [0.999825, 500, 1500, "\/isu\/users\/students-262-0"], "isController": false}, {"data": [0.999535, 500, 1500, "\/isu\/-265-1"], "isController": false}, {"data": [0.99959, 500, 1500, "\/isu\/my_marks\/-261-1"], "isController": false}, {"data": [0.99975, 500, 1500, "\/isu\/my_marks\/-261-0"], "isController": false}, {"data": [0.999365, 500, 1500, "\/isu\/my_group-260"], "isController": false}, {"data": [0.999265, 500, 1500, "\/isu\/-265"], "isController": false}, {"data": [0.99933, 500, 1500, "\/isu\/my_marks\/-261"], "isController": false}]}, function(index, item){
        switch(index){
            case 0:
                item = item.toFixed(3);
                break;
            case 1:
            case 2:
                item = formatDuration(item);
                break;
        }
        return item;
    }, [[0, 0]], 3);

    // Create statistics table
    createTable($("#statisticsTable"), {"supportsControllersDiscrimination": true, "overall": {"data": ["Total", 2100000, 0, 0.0, 18.718210000000028, 0, 3246, 12.0, 23.0, 112.0, 10482.703539160384, 17876.276458296936, 5162.380509659062], "isController": false}, "titles": ["Label", "#Samples", "KO", "Error %", "Average", "Min", "Max", "90th pct", "95th pct", "99th pct", "Transactions\/s", "Received", "Sent"], "items": [{"data": ["\/isu\/users\/students-262", 100000, 0, 0.0, 27.632989999999968, 1, 3214, 64.0, 115.0, 209.9900000000016, 499.530441385098, 1277.7822635784862, 378.06258991547946], "isController": false}, {"data": ["\/isu\/literature\/-264", 100000, 0, 0.0, 28.516450000000027, 1, 3219, 66.0, 117.0, 214.0, 499.57036948224527, 1277.8805978811347, 381.507840756949], "isController": false}, {"data": ["\/isu\/-259-1", 100000, 0, 0.0, 19.34153999999998, 1, 3233, 35.0, 90.0, 194.0, 499.4855299041987, 1094.211102213158, 164.38146833761226], "isController": false}, {"data": ["\/isu\/users\/teachers-263-0", 100000, 0, 0.0, 8.71737999999996, 0, 3060, 11.0, 22.0, 101.0, 499.55539569782894, 183.4864821871035, 193.67528524613095], "isController": false}, {"data": ["\/isu\/users\/teachers-263-1", 100000, 0, 0.0, 19.126999999999672, 0, 3203, 40.0, 94.0, 194.9900000000016, 499.5603868595636, 1094.3671180689119, 189.28655283350653], "isController": false}, {"data": ["\/isu\/literature\/-264-1", 100000, 0, 0.0, 19.275510000000157, 1, 3137, 39.0, 91.0, 185.9900000000016, 499.5878400319736, 1094.4268878565808, 189.296955012115], "isController": false}, {"data": ["\/isu\/users\/teachers-263", 100000, 0, 0.0, 27.869360000000114, 1, 3211, 67.0, 121.0, 218.0, 499.55290015436185, 1277.8362828159422, 382.9580338097403], "isController": false}, {"data": ["\/isu\/-259-0", 100000, 0, 0.0, 8.938809999999854, 0, 3170, 11.0, 20.950000000000728, 98.9900000000016, 499.2212149047486, 183.36466401476196, 161.85687826989894], "isController": false}, {"data": ["\/isu\/literature\/-264-0", 100000, 0, 0.0, 9.215730000000024, 0, 3205, 11.0, 24.0, 101.9900000000016, 499.5728652002538, 183.4928987278377, 192.2184657118164], "isController": false}, {"data": ["\/isu\/my_group-260-0", 100000, 0, 0.0, 8.916849999999991, 0, 3134, 11.0, 24.0, 104.9900000000016, 499.51297484952175, 183.4717351753915, 183.90272609206025], "isController": false}, {"data": ["\/isu\/-259", 100000, 0, 0.0, 28.307019999999994, 1, 3246, 62.0, 116.0, 216.9900000000016, 499.2162305180866, 1276.9839876784074, 326.1481037271484], "isController": false}, {"data": ["\/isu\/my_group-260-1", 100000, 0, 0.0, 18.88689000000012, 1, 3125, 34.0, 87.0, 188.0, 499.51047972986476, 1094.2645543305061, 182.43839787008733], "isController": false}, {"data": ["\/isu\/users\/students-262-1", 100000, 0, 0.0, 18.881169999999877, 1, 3201, 36.0, 89.0, 184.0, 499.54042281101385, 1094.3258862003206, 186.83982610997882], "isController": false}, {"data": ["\/isu\/-265-0", 100000, 0, 0.0, 8.906630000000087, 0, 3071, 11.0, 21.0, 103.9900000000016, 499.6003197442047, 183.50418786064898, 185.39855615507594], "isController": false}, {"data": ["\/isu\/users\/students-262-0", 100000, 0, 0.0, 8.726590000000108, 0, 3065, 11.0, 22.0, 97.0, 499.53293670418157, 183.47915987614078, 191.2274523320695], "isController": false}, {"data": ["\/isu\/-265-1", 100000, 0, 0.0, 19.369129999999824, 1, 3147, 37.0, 92.0, 199.9900000000016, 499.62777730590705, 1094.5140987152072, 187.84833424099045], "isController": false}, {"data": ["\/isu\/my_marks\/-261-1", 100000, 0, 0.0, 19.239400000000114, 1, 3211, 39.0, 91.0, 189.0, 499.52295557742355, 1094.2895677206393, 186.34547756892167], "isController": false}, {"data": ["\/isu\/my_marks\/-261-0", 100000, 0, 0.0, 8.907210000000033, 0, 3116, 11.0, 21.0, 97.9900000000016, 499.52295557742355, 183.47651332820905, 188.296739114146], "isController": false}, {"data": ["\/isu\/my_group-260", 100000, 0, 0.0, 27.82975999999982, 1, 3197, 62.0, 114.0, 219.0, 499.5079846351344, 1277.728990655142, 366.33837545018156], "isController": false}, {"data": ["\/isu\/-265", 100000, 0, 0.0, 28.30114, 1, 3157, 65.0, 120.0, 224.0, 499.59782375187973, 1277.951751769513, 373.2347023146367], "isController": false}, {"data": ["\/isu\/my_marks\/-261", 100000, 0, 0.0, 28.17584999999999, 1, 3220, 66.0, 116.0, 213.0, 499.51546999410573, 1277.7469331311129, 374.6366024955793], "isController": false}]}, function(index, item){
        switch(index){
            // Errors pct
            case 3:
                item = item.toFixed(2) + '%';
                break;
            // Mean
            case 4:
            // Mean
            case 7:
            // Percentile 1
            case 8:
            // Percentile 2
            case 9:
            // Percentile 3
            case 10:
            // Throughput
            case 11:
            // Kbytes/s
            case 12:
            // Sent Kbytes/s
                item = item.toFixed(2);
                break;
        }
        return item;
    }, [[0, 0]], 0, summaryTableHeader);

    // Create error table
    createTable($("#errorsTable"), {"supportsControllersDiscrimination": false, "titles": ["Type of error", "Number of errors", "% in errors", "% in all samples"], "items": []}, function(index, item){
        switch(index){
            case 2:
            case 3:
                item = item.toFixed(2) + '%';
                break;
        }
        return item;
    }, [[1, 1]]);

        // Create top5 errors by sampler
    createTable($("#top5ErrorsBySamplerTable"), {"supportsControllersDiscrimination": false, "overall": {"data": ["Total", 2100000, 0, null, null, null, null, null, null, null, null, null, null], "isController": false}, "titles": ["Sample", "#Samples", "#Errors", "Error", "#Errors", "Error", "#Errors", "Error", "#Errors", "Error", "#Errors", "Error", "#Errors"], "items": [{"data": [], "isController": false}, {"data": [], "isController": false}, {"data": [], "isController": false}, {"data": [], "isController": false}, {"data": [], "isController": false}, {"data": [], "isController": false}, {"data": [], "isController": false}, {"data": [], "isController": false}, {"data": [], "isController": false}, {"data": [], "isController": false}, {"data": [], "isController": false}, {"data": [], "isController": false}, {"data": [], "isController": false}, {"data": [], "isController": false}, {"data": [], "isController": false}, {"data": [], "isController": false}, {"data": [], "isController": false}, {"data": [], "isController": false}, {"data": [], "isController": false}, {"data": [], "isController": false}, {"data": [], "isController": false}]}, function(index, item){
        return item;
    }, [[0, 0]], 0);

});
