function generateChartsColor( opacity ) {
    return 'rgba(' + Math.floor(Math.random() * 256) + ', '+ Math.floor(Math.random() * 256) +', '+ Math.floor(Math.random() * 256) +', ' + opacity + ')';
}

function buildDashboardChart(data){
    let colors = data.map(item => generateChartsColor('0.8'));
    let labels = data.map(item => item.month);
    let dataSet = data.map(item => (item.consumption).toFixed(2));

    let ctx = document.getElementById('consumeChart').getContext('2d');
    let consumeChart = new Chart(ctx, {
        type: 'bar',
        data: {
            labels: labels,
            datasets: [{
                data: dataSet,
                backgroundColor: colors,
                borderColor: colors,
                borderWidth: 1
            }]
        },
        options: {
            responsive: true,
            scales: {
                yAxes: [{
                    ticks: {
                        beginAtZero: true
                    }
                }]
            },
            title: {
                display: false,
            },
            legend: {
                display: false,
            }
        }
    });
}

$.ajax({
    url: '/api/v1/measures',
    type: 'json',
    method: 'get',
    success: function (data) {
        buildDashboardChart(data)
        buildVoltageChart()
    }
})

var randomScalingFactor = function() {
    return Math.ceil(Math.random() * 10.0) * Math.pow(10, Math.ceil(Math.random() * 5));
};


function buildVoltageChart(){
    let ctx = document.getElementById('voltageChart').getContext('2d');
    var myLineChart = new Chart(ctx, {
        type: 'line',
        data: {
            labels: ["16:49","16:50","16:51","16:52","16:53","16:54","16:55","16:56","16:57","16:58","16:59","17:00","17:01","17:02","17:03","17:04","17:05","17:06","17:07","17:08","17:09","17:10"],
            datasets: [{
                label: 'tensão',
                backgroundColor: generateChartsColor('1'),
                borderColor: generateChartsColor('1'),
                fill: false,
                data: [
                    125,
                    127,
                    127,
                    128,
                    124,
                    127,
                    128,
                    125,
                    127,
                    127,
                    128,
                    124,
                    127,
                    128,
                    127,
                    128,
                    124,
                    127,
                    128,
                ],
            }]
        },
        options: {
            responsive: true,
            title: {
                display: false,
            },
            scales: {
                xAxes: [{
                    display: true,
                }],
                yAxes: [{
                    display: true,
                    labelString: 'value'
                }]
            }
        }
    });
}
