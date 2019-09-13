package eu.arrowhead.common.dto;

import java.io.Serializable;

public class GatewayProviderConnectionRequestDTO implements Serializable {
	
	//=================================================================================================
	// members
	
	private static final long serialVersionUID = 2845753936695022228L;
	
	private RelayRequestDTO relay;
	private SystemRequestDTO consumer;
	private SystemRequestDTO provider;
	private CloudRequestDTO consumerCloud;
	private CloudRequestDTO providerCloud;
	private String serviceDefinition;
	private String consumerGWPublicKey;
	
	//=================================================================================================
	// methods

	//-------------------------------------------------------------------------------------------------
	public GatewayProviderConnectionRequestDTO() {}
	
	//-------------------------------------------------------------------------------------------------
	public GatewayProviderConnectionRequestDTO(final RelayRequestDTO relay, final SystemRequestDTO consumer, final SystemRequestDTO provider, final CloudRequestDTO consumerCloud, 
											   final CloudRequestDTO providerCloud, final String serviceDefinition, final String consumerGWPublicKey) {
		this.relay = relay;
		this.consumer = consumer;
		this.provider = provider;
		this.consumerCloud = consumerCloud;
		this.providerCloud = providerCloud;
		this.serviceDefinition = serviceDefinition;
		this.consumerGWPublicKey = consumerGWPublicKey;
	}

	//-------------------------------------------------------------------------------------------------
	public RelayRequestDTO getRelay() { return relay; }
	public SystemRequestDTO getConsumer() { return consumer; }
	public SystemRequestDTO getProvider() { return provider; }
	public CloudRequestDTO getConsumerCloud() { return consumerCloud; }
	public CloudRequestDTO getProviderCloud() { return providerCloud; }
	public String getServiceDefinition() { return serviceDefinition; }
	public String getConsumerGWPublicKey() { return consumerGWPublicKey; }

	//-------------------------------------------------------------------------------------------------
	public void setRelay(final RelayRequestDTO relay) { this.relay = relay; }
	public void setConsumer(final SystemRequestDTO consumer) { this.consumer = consumer; }
	public void setProvider(final SystemRequestDTO provider) { this.provider = provider; }
	public void setConsumerCloud(final CloudRequestDTO consumerCloud) { this.consumerCloud = consumerCloud; }
	public void setProviderCloud(final CloudRequestDTO providerCloud) { this.providerCloud = providerCloud; }
	public void setServiceDefinition(final String serviceDefinition) { this.serviceDefinition = serviceDefinition; }
	public void setConsumerGWPublicKey(final String consumerGWPublicKey) { this.consumerGWPublicKey = consumerGWPublicKey; }	
}