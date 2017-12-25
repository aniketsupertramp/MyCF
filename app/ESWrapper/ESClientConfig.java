package ESWrapper;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.cluster.ClusterName;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class ESClientConfig {

    private static Client createESClient(String hostVal,String clusterName) throws UnknownHostException {
        Settings.Builder builder = Settings.builder().put("cluster.name", clusterName);
        builder.put("client.transport.ping_timeout", "120s");
        TransportClient client = new PreBuiltTransportClient(builder.build());
        client.addTransportAddress(new TransportAddress(InetAddress.getByName(hostVal),9200));
        return client;
    }
}
