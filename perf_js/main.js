const request = require("request");
//build a 100 links array
const url_list = [];
url_list.push(...Array(50).fill("https://www.google.com"));
url_list.push(...Array(50).fill("https://www.bing.com"));

const batch_num = 10; // send 10 Http requesta at one time
let batch_index = batch_num;
let resolvehandler = null;

function download_link(url) {
  request(
    {
      url: url,
      timeout: 1000,
    },
    function (_error, _response, body) {
      if (body) {
        console.log(body.length);
      }
      batch_index = batch_index - 1;
      if (batch_index == 0) {
        batch_index = batch_num;
        resolvehandler();
      }
    }
  );
}

function download_batch(u_list) {
  for (j = 0; j < batch_num; j++) {
    download_link(u_list[j]);
  }
}

async function download_all(u_list) {
  let loop_count = u_list.length / batch_num;
  console.time("test");
  for (var i = 0; i < loop_count; i++) {
    await new Promise((resolve, _) => {
      download_batch(u_list.slice(i * 10, i * 10 + 10));
      resolvehandler = resolve;
    });
  }
  console.timeEnd("test");
}

download_all(url_list);
