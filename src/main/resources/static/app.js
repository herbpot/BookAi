let posts = JSON.parse(localStorage.getItem('posts')) || [];  // 로컬 스토리지에서 글 목록 불러오기

function renderHomePage() {
  const mainContent = document.getElementById('main-content');
  mainContent.innerHTML = `
    <h2>게시글</h2>
    <div class="post-list">
      ${posts.length === 0 ? `<p>작성된 글이 없습니다.</p>` : 
        posts.map(post => `
          <div class="post-card">
            <h3>${post.username}</h3>
            <p>${post.date}</p>
            <p>${post.content}</p>
            <button class="edit-btn" onclick="editPost(${post.id})">수정</button>
            <button class="delete-btn" onclick="deletePost(${post.id})">삭제</button>
          </div>
        `).join('')}
    </div>
  `;
}

function renderWritePage(postToEdit = null) {
  const mainContent = document.getElementById('main-content');
  const pageTitle = postToEdit ? '글 수정하기' : '새 글 남기기';
  const buttonText = postToEdit ? '수정 완료' : '작성 완료';

  mainContent.innerHTML = `
    <h2>${pageTitle}</h2>
    <div class="write">
      <form id="write-form">
        <input type="text" id="username" placeholder="작성자 이름" value="${postToEdit ? postToEdit.username : ''}" required />
        <textarea id="content" placeholder="내용을 입력하세요" required>${postToEdit ? postToEdit.content : ''}</textarea>
        <button type="submit">${buttonText}</button>
      </form>
    </div>
  `;

  const form = document.getElementById('write-form');
  form.addEventListener('submit', function (e) {
    e.preventDefault();
    const username = document.getElementById('username').value;
    const content = document.getElementById('content').value;

    if (postToEdit) {
      // 수정할 게시글
      postToEdit.username = username;
      postToEdit.content = content;
      postToEdit.date = new Date().toISOString().split('T')[0]; // 수정 날짜로 변경
    } else {
      // 새 게시글 추가
      const newPost = {
        id: posts.length + 1,
        username,
        date: new Date().toISOString().split('T')[0], // 현재 날짜
        content
      };
      posts.push(newPost);
    }

    // 로컬 스토리지에 저장
    localStorage.setItem('posts', JSON.stringify(posts));

    // 홈 페이지로 돌아가기
    showHomePage();
  });
}

function deletePost(postId) {
  // 해당 게시글 삭제
  posts = posts.filter(post => post.id !== postId);

  // 로컬 스토리지에 삭제된 글 목록 저장
  localStorage.setItem('posts', JSON.stringify(posts));

  // 홈 페이지로 돌아가기 (삭제 후 자동 리렌더링)
  showHomePage();
}

function editPost(postId) {
  // 수정할 게시글 찾기
  const postToEdit = posts.find(post => post.id === postId);

  // 글 수정 페이지로 이동
  renderWritePage(postToEdit);
}

function showHomePage() {
  renderHomePage();
}

function showWritePage() {
  renderWritePage();
}

// 초기 로드 시 홈 페이지 표시
showHomePage();
