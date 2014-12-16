<h1 id="eksplorasi-wso2-complex-event-processor">Eksplorasi WSO2 Complex Event Processor</h1>

<blockquote>
  <p>Disusun Oleh:</p>
  
  <ol>
  <li>Dimas Angga S / 13510046</li>
  <li>Inov Yomanovian / 13510067</li>
  <li>Pande Made P P / 13510082</li>
  <li>Yanuar Aristya E P / 13511039</li>
  <li>Arini Sirait / 13511082</li>
  </ol>
</blockquote>

<hr>



<h2 id="table-of-contents">Table of Contents</h2>

<p><div class="toc"><div class="toc">
<ul>
<li><a href="#eksplorasi-wso2-complex-event-processor">Eksplorasi WSO2 Complex Event Processor</a><ul>
<li><a href="#table-of-contents">Table of Contents</a></li>
<li><a href="#complex-event-processor-cep">Complex Event Processor (CEP)</a><ul>
<li><a href="#arsitektur-wso2-cep">Arsitektur WSO2 CEP</a></li>
<li><a href="#flow-wso2-cep">Flow WSO2 CEP</a></li>
</ul>
</li>
<li><a href="#eksplorasi-cep">Eksplorasi CEP</a></li>
</ul>
</li>
</ul>
</div>
</div>
</p>

<hr>

<p><a href="http://wso2.com/products/complex-event-processor/"><img src="https://lh3.googleusercontent.com/-Toy0be9x6O8/VJA5PqdwLaI/AAAAAAAAAFU/DRF0RQ3NF4s/s0/cep-logo-h42.png" alt="" title="cep-logo"></a></p>



<h2 id="complex-event-processor-cep">Complex Event Processor (CEP)</h2>

<p>WSO2CEP merupakan <em>framework</em> untuk mengidentifikasi event yang terjadi pada suatu proses bisnis, dan melakukan suatu aksi yang sudah didefinisikan.</p>

<p>Contoh event:</p>

<ol>
<li>Pesawat mendarat</li>
<li>Pesawat lepas landas</li>
</ol>



<h3 id="arsitektur-wso2-cep">Arsitektur WSO2 CEP</h3>

<p><img src="https://lh6.googleusercontent.com/-XkTLbJvSYXU/VJBT72uO05I/AAAAAAAAAFo/RsEQ-BwtuU8/s0/architecture.png" alt="enter image description here" title="architecture.png"></p>

<p>CEP dapat menerima dan memberikan response terhadap event dalam berbagai bentuk seperti HTTP, SOAP, dan Email dikarenakan CEP memiliki Input/Output Event Adaptor. Event tersebut lalu masuk ke event-stream manager, yang lalu akan diproses dan diberikan outputnya.</p>

<h3 id="flow-wso2-cep">Flow WSO2 CEP</h3>

<p><img src="https://lh4.googleusercontent.com/-nkQ8_2lvfaI/VJBUoSmCE0I/AAAAAAAAAF8/pySEbfucbgI/s0/flow.png" alt="enter image description here" title="flow.png"></p>

<p>Berikut alur kerja CEP, seperti yang sudah dijelaskan sebelumnya.</p>

<hr>

<h2 id="eksplorasi-cep">Eksplorasi CEP</h2>

<p><strong>Instalasi WSO2 CEP</strong> <br>
Eksplorasi dilakukan pada platform Windows, berikut petunjuk instalasinya: <br>
 1. <a href="https://docs.wso2.com/display/CEP310/Downloading+the+Product">Download WSO2 CEP</a> <br>
 2. Setup JAVA_HOME <br>
 3. Jalankan <code>wso2server.bat</code> yang terdapat pada folder CEP_HOME/bin <br>
 4. Tunggu hingga diberikan address dari management console. Biasanya pada <a href="http://localhost:9443/carbon">http://localhost:9443/carbon</a> <br>
 5. Login dengan <code>admin/admin</code></p>

<p>Untuk informasi lebih mengenai instalasi, berikut pranala menuju petunjuk instalasi CEP dari dokumentasi WSO2 CEP. <br>
<a href="https://docs.wso2.com/display/CEP310/Installing+the+Product">WSO2 CEP Installation Guide</a></p>

<p><strong>Eksplorasi fitur CEP</strong> <br>
Dalam melakukan eksplorasi, kami menggunakan contoh untuk memulai memahami cara kerja CEP, lalu mencoba membuat event stream baru dengan memanfaatkan CEP.</p>

<p>Untuk informasi lebih mengenai cara memulai menggunakan WSO2 CEP dengan contoh, dapat mengakses pranala berikut. <br>
<a href="https://docs.wso2.com/display/CEP310/Getting+Started+with+CEP">Getting Started with WSO2 CEP</a></p>

<p>Kami mebuat sebuah event stream <em>book publisher</em>. Stream tersebut akan menerima event pemesanan buku lalu mencatat informasi pemesanan tersebut kedalam database.</p>

<p>Simulasi pemesanan buku diimplementasikan pada <code>src/main/java/org/example/bookpublisher/BookPublisherClient.java</code></p>

<p>Langkah menjalankan program</p>

<ol>
<li>Siapkan database untuk pencatatan pemesanan buku</li>
<li>Buka terminal/cmd</li>
<li>Jalankan <code>ant bookPublisherClient</code></li>
<li>Amati perubahan yang terjadi di database</li>
</ol>