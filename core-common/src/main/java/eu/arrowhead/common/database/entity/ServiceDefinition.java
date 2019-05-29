package eu.arrowhead.common.database.entity;

import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.OneToMany;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import eu.arrowhead.common.Defaults;

@Entity
@NamedEntityGraph (name = "serviceDefinitionWithServiceRegistryEntries",
	attributeNodes = {
			@NamedAttributeNode (value = "serviceRegistryEntries")
	})
public class ServiceDefinition {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column (nullable = false, unique = true, length = Defaults.VARCHAR_BASIC)
	private String serviceDefinition;
	
	@Column (nullable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private ZonedDateTime createdAt;
	
	@Column (nullable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
	private ZonedDateTime updatedAt;
	
	@OneToMany (mappedBy = "serviceDefinition", fetch = FetchType.LAZY, orphanRemoval = true)
	@OnDelete (action = OnDeleteAction.CASCADE)
	private Set<ServiceRegistry> serviceRegistryEntries = new HashSet<>();
	
	@OneToMany (mappedBy = "serviceDefinition", fetch = FetchType.LAZY, orphanRemoval = true)
	@OnDelete (action = OnDeleteAction.CASCADE)
	private Set<IntraCloudAuthorization> intraCloudAuthorizations = new HashSet<>();
	
	@OneToMany (mappedBy = "serviceDefinition", fetch = FetchType.LAZY, orphanRemoval = true)
	@OnDelete (action = OnDeleteAction.CASCADE)
	private Set<InterCloudAuthorization> interCloudAuthorizations = new HashSet<>();
	
	public ServiceDefinition() {
		
	}

	public ServiceDefinition(final String serviceDefinition) {
		this.serviceDefinition = serviceDefinition;
	}

	public long getId() {
		return id;
	}

	public void setId(final long id) {
		this.id = id;
	}

	public String getServiceDefinition() {
		return serviceDefinition;
	}

	public void setServiceDefinition(final String serviceDefinition) {
		this.serviceDefinition = serviceDefinition;
	}

	public ZonedDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(final ZonedDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public ZonedDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(final ZonedDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	public Set<ServiceRegistry> getServiceRegistryEntries() {
		return serviceRegistryEntries;
	}

	public void setServiceRegistryEntries(final Set<ServiceRegistry> serviceRegistryEntries) {
		this.serviceRegistryEntries = serviceRegistryEntries;
	}
		
	public Set<IntraCloudAuthorization> getIntraCloudAuthorizations() {
		return intraCloudAuthorizations;
	}

	public void setIntraCloudAuthorizations(final Set<IntraCloudAuthorization> intraCloudAuthorizations) {
		this.intraCloudAuthorizations = intraCloudAuthorizations;
	}
		
	public Set<InterCloudAuthorization> getInterCloudAuthorizations() {
		return interCloudAuthorizations;
	}

	public void setInterCloudAuthorizations(final Set<InterCloudAuthorization> interCloudAuthorizations) {
		this.interCloudAuthorizations = interCloudAuthorizations;
	}

	@Override
	public String toString() {
		return "ServiceDefinition [id=" + id + ", serviceDefinition=" + serviceDefinition + "]";
	}
		
}
