function generateChartsColor( opacity ) {
    return 'rgba(' + Math.floor(Math.random() * 256) + ', '+ Math.floor(Math.random() * 256) +', '+ Math.floor(Math.random() * 256) +', ' + opacity + ')';
}

function buildDashboardChart(data){
    let colors = data.map(item => generateChartsColor('0.8'));
    let labels = data.map(item => item.month);
    let dataSet = data.map(item => item.consumption.toFixed(2));

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
    }
})