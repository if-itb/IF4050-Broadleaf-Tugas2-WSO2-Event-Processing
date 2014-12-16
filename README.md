Eksplorasi WSO2 Complex Event Processor
=

> Disusun Oleh:
> 
>  3. Dimas Angga S / 13510046
>  1. Inov Yomanovian / 13510067
>  2. Pande Made P P / 13510082
>  4. Yanuar Aristya E P / 13511039
>  5. Arini Sirait / 13511082


----------
Table of Contents
-
[TOC]

----------


[![](https://lh3.googleusercontent.com/-Toy0be9x6O8/VJA5PqdwLaI/AAAAAAAAAFU/DRF0RQ3NF4s/s0/cep-logo-h42.png "cep-logo")](http://wso2.com/products/complex-event-processor/)

Complex Event Processor (CEP)
- 
WSO2CEP merupakan *framework* untuk mengidentifikasi event yang terjadi pada suatu proses bisnis, dan melakukan suatu aksi yang sudah didefinisikan.

Contoh event:

 1. Pesawat mendarat
 2. Pesawat lepas landas

###Arsitektur WSO2 CEP
![enter image description here](https://lh6.googleusercontent.com/-XkTLbJvSYXU/VJBT72uO05I/AAAAAAAAAFo/RsEQ-BwtuU8/s0/architecture.png "architecture.png")

CEP dapat menerima dan memberikan response terhadap event dalam berbagai bentuk seperti HTTP, SOAP, dan Email dikarenakan CEP memiliki Input/Output Event Adaptor. Event tersebut lalu masuk ke event-stream manager, yang lalu akan diproses dan diberikan outputnya.

###Flow WSO2 CEP
![enter image description here](https://lh4.googleusercontent.com/-nkQ8_2lvfaI/VJBUoSmCE0I/AAAAAAAAAF8/pySEbfucbgI/s0/flow.png "flow.png")

Berikut alur kerja CEP, seperti yang sudah dijelaskan sebelumnya.


----------


Eksplorasi CEP
-
**Instalasi WSO2 CEP**
Eksplorasi dilakukan pada platform Windows, berikut petunjuk instalasinya:
 1. [Download WSO2 CEP](https://docs.wso2.com/display/CEP310/Downloading+the+Product)
 2. Setup JAVA_HOME
 3. Jalankan `wso2server.bat` yang terdapat pada folder CEP_HOME/bin
 4. Tunggu hingga diberikan address dari management console. Biasanya pada http://localhost:9443/carbon
 5. Login dengan `admin/admin`

Untuk informasi lebih mengenai instalasi, berikut pranala menuju petunjuk instalasi CEP dari dokumentasi WSO2 CEP.
[WSO2 CEP Installation Guide](https://docs.wso2.com/display/CEP310/Installing+the+Product)

**Eksplorasi fitur CEP**
Dalam melakukan eksplorasi, kami menggunakan contoh untuk memulai memahami cara kerja CEP, lalu mencoba membuat event stream baru dengan memanfaatkan CEP.

Untuk informasi lebih mengenai cara memulai menggunakan WSO2 CEP dengan contoh, dapat mengakses pranala berikut.
[Getting Started with WSO2 CEP](https://docs.wso2.com/display/CEP310/Getting+Started+with+CEP)

Kami mebuat sebuah event stream *book publisher*. Stream tersebut akan menerima event pemesanan buku lalu mencatat informasi pemesanan tersebut kedalam database.

Simulasi pemesanan buku diimplementasikan pada `src/main/java/org/example/bookpublisher/BookPublisherClient.java`

Langkah menjalankan program

 1. Siapkan database untuk pencatatan pemesanan buku
 2. Buka terminal/cmd
 2. Jalankan `ant bookPublisherClient`
 3. Amati perubahan yang terjadi di database