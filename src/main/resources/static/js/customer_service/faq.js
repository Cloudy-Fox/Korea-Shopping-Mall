const faqBoardSection = document.getElementById('faq-board-section');
const faqBoardLies = faqBoardSection.getElementsByTagName('li');
[...faqBoardLies].forEach(boardLi => {
    boardLi.onclick = () => {
        boardLi.querySelector('p').toggleAttribute('active');
    }
})