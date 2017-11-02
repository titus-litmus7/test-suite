<?xml version="1.0"?>
<xsl:stylesheet 
    xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">

<!--
    This file contains the description sections for the report as well as
    the headlines for the section.
    
    The format is always <h2> as main headline, <h3> as description headline 
    and some <p> or <ul> as text.
-->

<!--- ## Description: Navigation Section ## -->
<xsl:template name="headline-navigation">
    <h2>Navigation</h2>
</xsl:template>
<xsl:template name="description-navigation">
    <div class="description">   
        
        <p>
            This is the navigation section. Just click on a topic to jump directly to it.
        </p>
    </div>
</xsl:template>


<!--- ## Description: Load Profile ## -->
<xsl:template name="headline-load-profile">
    <h2>Load Profile</h2>
</xsl:template>
<xsl:template name="description-load-profile">
    <div class="description">   
        
        <p>
            This section shows the load profile as configured in the properties files of your test suite.
        </p>
    </div>
</xsl:template>

<!--- ## Description: General ## -->
<xsl:template name="headline-general">
    <h2>Overview</h2>
</xsl:template>
<xsl:template name="description-general">
    <div class="description">   
        
        <p>
            The overview section shows some general information about both load tests. This enables you to compare settings, 
            runtime, and profiles. The initial test run is labeled <em>baseline</em>. The test run that is compared to the baseline is 
            labeled <em>measurement run</em>.
        </p>
        <p>
        	In the later sections, the percentage values show you the development of the performance in comparison to the baseline. 
        	Please note that the total columns (total throughput and total errors) might present misleading values 
        	if the two load tests used different runtime configurations. All other values are normalized 
        	in respect to the runtime and therefore easily comparable. Positive numbers in the count section mean an improvement 
        	of the throughput over the baseline. Negative values indicate a decrease of throughput. An increase in the number of errors is 
        	indicated with positive numbers, while a decrease in errors is shown in negative numbers. 
        	An infinite sign indicates the occurrence of errors in comparison to an error-free baseline.<br/>
        	For all runtime numbers, positive values indicate a poorer performance, while negative value show an improvement - 
        	smaller runtime values - over the baseline.
        </p>	 
        <p>
        	Added or removed transactions, actions, or requests are indicated. No comparison is provided for these.
        </p>
    </div>
</xsl:template>

<!--- ## Description:  Network ## -->
<xsl:template name="headline-network">
    <h2>Network</h2>
</xsl:template>
<xsl:template name="description-network">
    <div class="description">   
        
        <p>
            The network section covers the areas of incoming and outgoing traffic during the load test. <em>Sent Bytes</em> is an estimated number based on the data that was given to the network layer. Cookies, for example, are not included. <em>Received Bytes</em> is an accurate number because it is based on the data received and includes http-header information.
        </p>
        <p>
            Depending on the test runtime, the numbers for per hour and per day might be estimates based on a linear projection of the available data.
        </p>
        <p>*) numbers might be projected</p>
    </div>
</xsl:template>

<!--- ## Description: Active Test Users ## -->
<xsl:template name="headline-active-users">
    <h2>Users</h2>
</xsl:template>
<xsl:template name="description-active-users">
    <div class="description">   
        
        <p>
            The number of active users shows the number of test cases that were underway concurrently. The chart shows ramp-up and shutdown periods, as well as potential problems with agents, which are often visible as sudden drops in the active user count. This section also visualizes the test user setup.
        </p>
    </div>
</xsl:template>

<!--- ## Description: Transaction Summary ## -->
<xsl:template name="headline-transaction-summary">
    <h2>Transactions</h2>
</xsl:template>
<xsl:template name="description-transaction-summary">
    <div class="description">   
        
        <p>
            A transaction is a completed test case, and a test case consists of one or more actions. The runtime of a transaction contains the runtime of all actions within the test case, think times, and the processing time of the test code itself. If the test path of the test case is heavily randomized, the runtime of transactions might vary significantly. The average runtime shows the development of tests over time and is especially helpful in evaluating the outcome of long-running tests.
        </p>
        <p>*) numbers might be projected</p>
    </div>
</xsl:template>

<!--- ## Description: Action Summary ## -->
<xsl:template name="headline-action-summary">
    <h2>Actions</h2>
</xsl:template>
<xsl:template name="description-action-summary">
    <div class="description">   
        
        <p>
            An action is part of a test case and consists of a prevalidation, an execution, and a postvalidation. 
            While the prevalidation ensures that the necessary data is available for the execution of this test step, 
            the postvalidation evaluates the results and compares them to the expectations. 
            The data shown here is the time spent in the execution routine of an action. 
            Therefore its runtime includes the runtime of a request, e.g. an http operation, and 
            the necessary time to prepare, send, wait for, and receive the data.
        </p>
        <p>*) numbers might be projected</p>
    </div>
</xsl:template>

<!--- ## Description: Request Summary ## -->
<xsl:template name="headline-request-summary">
    <h2>Requests</h2>
</xsl:template>
<xsl:template name="description-request-summary">
    <div class="description">   
        
        <p>
            The request section is the most important statistical section when testing web applications. It directly reflects the loading time of pages or page components. Each row holds the data of one specific request. Its name is defined within the test case as timer name. The <em>Count</em> section of the table shows the total number of executions (<em>Total</em>), the calculated executions per seconds (<em>1/s</em>) and per minute (<em>1/min</em>), as well as projections or calculations of the executions per hour (<em>1/h</em>) and day (<em>1/d</em>). The <em>Error</em> section shows the total number (<em>Total</em>) of errors that occurred during loading of the page or page component. The error count does not include errors detected during the postvalidation of the data received. Typical error situations are http-response codes such as 404 and 505, timeouts, or connection resets.
        </p>
        <p>
            The runtime section of the table shows the median, the arithmetic mean, and the minimum and maximum runtime encountered, as well as the standard deviation of all data within that series. The runtime segmentation section shows several runtime segments and the number of requests within the segment's definition.
        </p>
        <p>
            If the runtime of the test case is shorter than a displayed time period--for example if the test runtime was 30 minutes and the time period is in hours--the numbers are a linear projection. That means they show a possible outcome of a longer test run, assuming load and application behavior remain the same.
        </p>
        <p>*) numbers might be projected</p>
    </div>
</xsl:template>

<!--- ## Description: Custom Timer Summary ## -->
<xsl:template name="headline-custom-timer-summary">
    <h2>Custom Timers</h2>
</xsl:template>
<xsl:template name="description-custom-timer-summary">
    <div class="description">   
        
        <p>
            The custom timers includes all timers that have been placed individually within the test code. The chart and data description is identical to the request section.
        </p>
        <p>*) numbers might be projected</p>
    </div>
</xsl:template>

<!--- ## Description: Error Summary ## -->
<xsl:template name="headline-error-summary">
    <h2>Errors</h2>
</xsl:template>
<xsl:template name="description-error-summary">
    <div class="description">   
        
        <p>
            This table contains all errors and their stacktraces thrown by the test cases. This data helps to identify application errors or test problems.
        </p>
    </div>
</xsl:template>

<!--- ## Description: Http Response Codes ## -->
<xsl:template name="headline-http-response-codes">
    <h2>Http Response Codes</h2>
</xsl:template>
<xsl:template name="description-http-response-codes">
    <div class="description">   
        
        <p>
            If the test run included web activities or other activities that return an HTTP response code, it can be found here. The table contains the response code, the total number of occurrences, and the percentage in relation to the total number of response codes.
        </p>
    </div>
</xsl:template>

<!--- ## Description: Event Summary ## -->
<xsl:template name="headline-event-summary">
    <h2>Events</h2>
</xsl:template>
<xsl:template name="description-event-summary">
    <div class="description">   
        
        <p>
            This table contains all events that occurred during the load test.
			Events are used to indicate that the test has encountered a situation
            which is not an error, but is too important to ignore or to write to the log only.
        </p>
    </div>
</xsl:template>

<!--- ## Description: Configuration ## -->
<xsl:template name="headline-configuration">
    <h2>Configuration</h2>
</xsl:template>
<xsl:template name="description-configuration">
    <div class="description">   
        
        <p>
            The configuration section lists the test configuration used to run this test. It helps to make the test reproducible and preserves the test settings for later test evaluation.
        </p>
    </div>
</xsl:template>

<!--- ## Description: Agents ## -->
<xsl:template name="headline-agents">
    <h2>Agent Information</h2>
</xsl:template>
<xsl:template name="description-agents">
    <div class="description">   
        
        <p>
            This section reports the resource utilization of each user agent in terms of CPU and memory usage. This helps to identify potential resource bottlenecks which might have influenced the load test. Please note that all data is local to the Java Virtual Machine of the agent and therefore covers only a process view. 
        </p>
    </div>
</xsl:template>

<!--- ## Description:  ## 
<xsl:template name="">
    <h2></h2>
    <div class="description">   
        
        <p>
        </p>
    </div>
</xsl:template> -->

<!-- ## Headline for Report1 -->
<xsl:template name="headline-general-report1">
    <h3 id="anchor-general-report1">Baseline</h3>
</xsl:template>

<!-- ## Headline for Report2 -->
<xsl:template name="headline-general-report2">
    <h3 id="anchor-general-report2">Measurement Run</h3>
</xsl:template>


</xsl:stylesheet>
