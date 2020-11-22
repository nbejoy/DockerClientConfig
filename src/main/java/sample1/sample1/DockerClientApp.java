package sample1.sample1;

import java.util.Iterator;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.model.Container;
import com.github.dockerjava.core.DefaultDockerClientConfig;
import com.github.dockerjava.core.DockerClientBuilder;
import java.util.List;

public class DockerClientApp {

	public static void main(String[] args) {
		
  DefaultDockerClientConfig config=DefaultDockerClientConfig.createDefaultConfigBuilder().withDockerHost("tcp://localhost:2375").build();
  DockerClient client= DockerClientBuilder.getInstance(config).build();
  System.out.println(client.versionCmd());
  client.createContainerCmd("redis");
 List<Container> containers=client.listContainersCmd().withShowAll(true).exec();
System.out.println("Total no. of containers="+ containers.size());
Iterator<Container> it=containers.iterator();
while(it.hasNext())
{ Container container= it.next();
System.out.println(container.getImage()+"="+container.getStatus());

}
	}

}
