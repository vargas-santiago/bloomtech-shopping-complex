const playlistForm = document.querySelector("#create-playlist-form");
const playlistsList = document.querySelector("#playlists");

playlistForm.onsubmit = async function(evt) {
  evt.preventDefault();
  const name = document.querySelector("#playlist-name").value;
  const customerId = "testCustomer";
  const playlistObj = {
    "name": name,
    "customerId": customerId,
    "songCount": 0
  }
  axios.post("https://svebsuap66.execute-api.us-west-2.amazonaws.com/prod/playlists", playlistObj, {
    authorization: {
      'x-api-key': 'CG7p17N9EO9GAoFync4Qx5zL7G5jSvaw6Xon82kf'
    }
  }).then((res) => {
    console.log(res);
    window.location.reload();
  })
}
