/*
 * Created by Dyan at 2019/3/19 16:35
 */

var ctx = document.getElementById('myChart').getContext('2d');
let chart = new Chart(ctx, {
    type: 'line',
    data: {
        datasets: [{
            label: 'First dataset',
            data: [0, 20, 40, 50, 67, 12, 24]
        }],
        labels: ['January', 'February', 'March', 'April', 'May', 'June', 'July']
    },
    options: {
        scales: {
            yAxes: [{
                ticks: {
                    suggestedMin: 50,
                    suggestedMax: 100
                }
            }]
        },
        maintainAspectRatio: false,
    }
});