from locust import HttpUser, TaskSet, task, between

class UserBehavior(TaskSet):

    @task
    def get_fulfilment(self):
        url = "/api/v1/fulfilment"  # Specify the correct relative endpoint (path only)
        params = {}  # Add any required params here, or leave it empty
        headers = {"Accept": "application/json"}  # Add any required headers

        with self.client.get(url, params=params, headers=headers, catch_response=True) as response:
            if response.status_code == 200:
                response.success()
                print(f"Status Code: {response.status_code}, Response: {response.text[:100]}")
            else:
                response.failure(f"Failed with status code: {response.status_code}")

class WebsiteUser(HttpUser):
    tasks = [UserBehavior]
    wait_time = between(1, 3)  # Wait between 1 and 3 seconds between tasks

    def on_start(self):
        pass  # Any setup needed before the tasks start

    def on_stop(self):
        pass  # Any teardown needed after the tasks stop
