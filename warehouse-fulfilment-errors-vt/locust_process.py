from locust import HttpUser, TaskSet, task, between

class UserBehavior(TaskSet):

    @task
    def get_fulfilment(self):
        url = "/api/v1/fulfilment/process"
        params = {}
        headers = {"Accept": "application/json"}

        with self.client.get(url, params=params, headers=headers, catch_response=True) as response:
            if response.status_code == 200:
                response.success()
                # print(f"Status Code: {response.status_code}, Response: {response.text[:100]}")
            else:
                response.failure(f"Failed with status code: {response.status_code}")

class WebsiteUser(HttpUser):
    tasks = [UserBehavior]
    # wait_time = between(1, 3)


    def on_start(self):
        pass

    def on_stop(self):
        pass
