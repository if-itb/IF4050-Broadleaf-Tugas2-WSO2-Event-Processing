package org.example.bookpublisher;

import org.wso2.carbon.databridge.agent.thrift.DataPublisher;
import org.wso2.carbon.databridge.agent.thrift.exception.AgentException;
import org.wso2.carbon.databridge.commons.exception.*;
import org.wso2.carbon.sample.pizzadelivery.client.KeyStoreUtil;

import java.net.MalformedURLException;

public class BookPublisherClient
{
    public static void main(String[] args)
            throws AgentException, MalformedURLException,
                   AuthenticationException, TransportException, MalformedStreamDefinitionException,
                   StreamDefinitionException, DifferentStreamDefinitionAlreadyDefinedException,
                   InterruptedException
    {

        KeyStoreUtil.setTrustStoreParams();

        String host = args[0];
        String port = args[1];
        String username = args[2];
        String password = args[3];

        // ORDER STREAM
        // ------------------------------------------------------------------------------------------------------------

        DataPublisher dataPublisher1 = new DataPublisher("tcp://" + host + ":" + port, username, password);

        String streamId1;
        try {
            streamId1 = dataPublisher1.findStream("orderStream", "1.0.1");
        } catch (NoStreamDefinitionExistException e) {
            streamId1 = dataPublisher1.defineStream("{" +
                                                  "  'name':'orderStream'," +
                                                  "  'version':'1.0.1'," +
                                                  "  'nickName': ''," +
                                                  "  'description': 'Order Stream'," +
                                                  "  'payloadData':[" +
                                                  "          {'name':'orderNo','type':'STRING'}," +
                                                  "          {'name':'customerName','type':'STRING'}," +
                                                  "          {'name':'orderInfo','type':'STRING'}," +
                                                  "          {'name':'orderedTime','type':'STRING'}" +
                                                  "  ]" +
                                                  "}");

        }
        Thread.sleep(1000);

        dataPublisher1.publish(streamId1, null, null, new Object[]{"Order1", "Budi", "Info1","Test"});
        dataPublisher1.publish(streamId1, null, null, new Object[]{"Order2", "Joni", "Info1","test"});
        dataPublisher1.publish(streamId1, null, null, new Object[]{"Order3", "Sulaiman", "Info1","test"});
        dataPublisher1.publish(streamId1, null, null, new Object[]{"Order4", "Afif", "Info1","test"});
        dataPublisher1.publish(streamId1, null, null, new Object[]{"Order5", "Sonny", "Info1","test"});
        dataPublisher1.publish(streamId1, null, null, new Object[]{"Order6", "Komeng", "Info1","test"});

        Thread.sleep(3000);
        dataPublisher1.stop();

        // DELIVERY STREAM
        // ------------------------------------------------------------------------------------------------------------

        DataPublisher dataPublisher = new DataPublisher("tcp://" + host + ":" + port, username, password);

        String streamId;
        try {
            streamId = dataPublisher.findStream("deliveryStream", "1.0.1");
        } catch (NoStreamDefinitionExistException e) {
            streamId = dataPublisher.defineStream("{" +
                                                  "  'name':'deliveryStream'," +
                                                  "  'version':'1.0.1'," +
                                                  "  'nickName': ''," +
                                                  "  'description': 'Delivery Stream'," +
                                                  "  'metaData':[" +
                                                  "          {'name':'deliveryNo','type':'STRING'}" +
                                                  "  ]," +
                                                  "  'payloadData':[" +
                                                  "          {'name':'orderNo','type':'STRING'}," +
                                                  "          {'name':'areaName','type':'STRING'}," +
                                                  "          {'name':'time','type':'LONG'}," +
                                                  "          {'name':'totalBill','type':'DOUBLE'}," +
                                                  "          {'name':'deliveredBy','type':'STRING'}" +
                                                  "  ]" +
                                                  "}");

        }
        Thread.sleep(2000);

        dataPublisher.publish(streamId, new Object[]{"Delivery1"}, null, new Object[]{"Order1", "Antapani", 100l, 50d, "DBot1"});
        Thread.sleep(8000);
        dataPublisher.publish(streamId, new Object[]{"Delivery2"}, null, new Object[]{"Order2", "Kopo", 50l, 70d, "DBot2"});
        Thread.sleep(8000);
        dataPublisher.publish(streamId, new Object[]{"Delivery3"}, null, new Object[]{"Order3", "Cimahi", 20l, 700d, "DBot1"});
        Thread.sleep(10000);
        dataPublisher.publish(streamId, new Object[]{"Delivery4"}, null, new Object[]{"Order4", "Lembang", 200l,1000d, "DBot1"});
        Thread.sleep(10000);
        dataPublisher.publish(streamId, new Object[]{"Delivery5"}, null, new Object[]{"Order5", "Dago", 50l, 600d, "DBot2"});
        Thread.sleep(10000);
        dataPublisher.publish(streamId, new Object[]{"Delivery5"}, null, new Object[]{"Order6", "Cisitu", 50l, 600d, "DBot1"});

        Thread.sleep(3000);
        dataPublisher.stop();

    }
}
