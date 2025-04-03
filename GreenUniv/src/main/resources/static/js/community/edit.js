const modifyBtn = document.getElementsByClassName("modify-btn")[0]

modifyBtn.addEventListener("click", async (e) => {
  e.preventDefault();
  const uri = e.target.href;
  const queryIndex = uri.indexOf("?");
  const queryString = uri.substring(queryIndex, uri.length);
  const params = new URLSearchParams(queryString);
  const form = new FormData();

  //const id = uri.substring(idIndex, uri.length - 1);
  const id = params.get("id")

  const title = document.getElementsByClassName("title")[0].value
  const content = document.getElementsByClassName("content")[0].value;
  const category = document.getElementsByClassName("category")[0].innerText;
  const view = document.getElementsByClassName("view")[0].innerText;

  form.append("id", id);
  form.append("title", title)
  form.append("content", content)
  form.append("category", category);
  form.append("view", view)

  await fetch(uri, {
    method: "POST",
    cache: "no-cache",
    body: form
  })
});
