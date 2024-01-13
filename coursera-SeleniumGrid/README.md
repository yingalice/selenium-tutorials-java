[Selenium Grid - Running Selenium tests in parallel](https://www.coursera.org/projects/selenium-grid-running-selenium-tests-in-parallel) from Coursera Project Network (instructor: Saurabh Dhingra)

=== Hub and Node architecture ===

Hub
- Central point where we load our tests
- Controls execution of tests and sends to node
- Only 1 hub in a Grid
- Launched on a single machine

Node
- Selenium instances that will execute the tests that you load on the hub
- Can be more than 1 Node in a Grid
- Nodes can be launched on multiple machines with different browsers and platforms

=== Running Selenium Grid ===

<u>CLI</u>

Hub and Node on same machine:
- `java -jar selenium-server-4.16.1.jar hub`
- `java -jar selenium-server-4.16.1.jar node --selenium-manager true`

Hub and Node on different machine:
- `java -jar selenium-server-4.16.1.jar hub`
- `java -jar selenium-server-4.16.1.jar node --selenium-manager true --hub http://<hub-ip>:4444`

<u>TOML file</u>

- `java -jar selenium-server-4.16.1.jar hub`
- `java -jar selenium-server-4.16.1.jar node --config node_a.toml`
- `java -jar selenium-server-4.16.1.jar node --config node_b.toml`