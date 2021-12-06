import requests
from requests.sessions import Session
import time
from threading import Thread, local
from queue import Queue

url_list = ["https://www.google.com/", "https://www.bing.com"] * 50
q = Queue(maxsize=0)  # Use a queue to store all URLs
for url in url_list:
    q.put(url)
thread_local = local()  # The thread_local will hold a Session object


def get_session() -> Session:
    if not hasattr(thread_local, 'session'):
        thread_local.session = requests.Session()  # Create a new Session if not exists
    return thread_local.session


def download_link() -> None:
    '''download link worker, get URL from queue until no url left in the queue'''
    session = get_session()
    while True:
        url = q.get()
        with session.get(url) as response:
            print(f'Read {len(response.content)} from {url}')
        q.task_done()          # tell the queue, this url downloading work is done


def download_all(urls) -> None:
    '''Start 10 threads, each thread as a wrapper of downloader'''
    thread_num = 10
    for _ in range(thread_num):
        t_worker = Thread(target=download_link)
        t_worker.start()
    q.join()                   # main thread wait until all url finished downloading


print("start work")
start = time.time()
download_all(url_list)
end = time.time()
print(f'download {len(url_list)} links in {end - start} seconds')
