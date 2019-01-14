function loadLotteries() {
    fetch("/lottery/all", {
        method: "get",
    }).then(
        resp => resp.json()
).then(lotteries => {
        for (const lottery of lotteries) {
        addLotteries(lottery);
    }
});
}

function addLotteries(lottery) {
    const tr = document.createElement("tr");
    tr.innerHTML = `
        <td>${lottery.id}</td>
        <td>${lottery.title}</td>
        <td>${lottery.startDate}</td>
        <td>${lottery.endDate}</td>
        <td>${lottery.lLimit}</td>
        <td>${lottery.winParticipantID}</td>
    `;
    document.getElementById("table-body").appendChild(tr);
}
