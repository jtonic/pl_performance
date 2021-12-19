import asyncio
import time
import aiohttp
from aiohttp.client import ClientSession


async def download_link(url: str, session: ClientSession):
    async with session.get(url) as response:
        result = await response.text()
        print(f'Read {len(result)} from {url}')


async def download_all(urls: list):
    my_conn = aiohttp.TCPConnector(limit=10)
    async with aiohttp.ClientSession(connector=my_conn) as session:
        tasks = []
        for url in urls:
            task = asyncio.ensure_future(
                download_link(url=url, session=session))
            tasks.append(task)
        # the await must be nest inside of the session
        await asyncio.gather(*tasks, return_exceptions=True)

url_list = ["http://localhost:8080/", "http://localhost:8080/"] * 50
start = time.time()
asyncio.run(download_all(url_list))
end = time.time()
print(f'download {len(url_list)} links in {end - start} seconds')
