import requests
from requests.sessions import Session
import time

url_list = ["http://localhost:8080/", "http://localhost:8080/"] * 50


def download_link(url: str, session: Session):
    with session.get(url) as response:
        result = response.content
        print(f'Read {len(result)} from {url}')


def download_all(urls: list):
    with requests.Session() as session:
        for url in urls:
            download_link(url, session=session)


start = time.time()
download_all(url_list)
end = time.time()
print(f'download {len(url_list)} links in {end - start} seconds')
