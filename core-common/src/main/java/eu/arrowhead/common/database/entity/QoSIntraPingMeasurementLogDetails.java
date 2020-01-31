package eu.arrowhead.common.database.entity;

import java.time.ZonedDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

@Entity
@Table(name = "qos_intra_ping_measurement_log_details")
public class QoSIntraPingMeasurementLogDetails {

	//=================================================================================================
	// members

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "measurement_log_id", referencedColumnName = "id", nullable = false, unique = true)
	private QoSIntraPingMeasurementLog measurementLog;

	@Column(name = "measured_system_address", nullable = false)
	private String measuredSystemAddress;

	@Column(name = "success_flag", nullable = false)
	private boolean successFlag = false;

	@Column(name = "timeout_flag", nullable = false)
	private boolean timeoutFlag = false;

	@Column(name = "error_message", nullable = true)
	private String errorMessage;

	@Column(name = "throwable", nullable = true)
	private String throwable;

	@Column(name = "size_", nullable = true)
	private Integer size;

	@Column(name = "rtt", nullable = true)
	private Integer rtt;

	@Column(name = "ttl", nullable = true)
	private Integer ttl;

	@Column(name = "duration", nullable = true)
	private Integer duration;

	@Column(name = "measured_at", nullable = false)
	private ZonedDateTime measuredAt;

	@Column(nullable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private ZonedDateTime createdAt;

	@Column(nullable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
	private ZonedDateTime updatedAt;

	//=================================================================================================
	// methods

	//-------------------------------------------------------------------------------------------------
	public QoSIntraPingMeasurementLogDetails() {}

	//-------------------------------------------------------------------------------------------------
	@PrePersist
	public void onCreate() {
		this.createdAt = ZonedDateTime.now();
		this.updatedAt = this.createdAt;
	}

	//-------------------------------------------------------------------------------------------------
	@PreUpdate
	public void onUpdate() {
		this.updatedAt = ZonedDateTime.now();
	}

	//-------------------------------------------------------------------------------------------------
	public QoSIntraPingMeasurementLog getMeasurementLog() { return measurementLog; }
	public String getMeasuredSystemAddress() { return measuredSystemAddress; }
	public boolean isSuccessFlag() { return successFlag; }
	public boolean isTimeoutFlag() { return timeoutFlag; }
	public String getErrorMessage() { return errorMessage; }
	public String getThrowable() { return throwable; }
	public Integer getSize() { return size; }
	public Integer getRtt() { return rtt; }
	public Integer getTtl() { return ttl; }
	public Integer getDuration() { return duration; }
	public ZonedDateTime getMeasuredAt() { return measuredAt; }

	//-------------------------------------------------------------------------------------------------
	public void setMeasurementLog(QoSIntraPingMeasurementLog measurementLog) { this.measurementLog = measurementLog; }
	public void setMeasuredSystemAddress(String measuredSystemAddress) { this.measuredSystemAddress = measuredSystemAddress; }
	public void setSuccessFlag(boolean successFlag) { this.successFlag = successFlag; }
	public void setTimeoutFlag(boolean timeoutFlag) { this.timeoutFlag = timeoutFlag; }
	public void setErrorMessage(String errorMessage) { this.errorMessage = errorMessage; }
	public void setThrowable(String throwable) { this.throwable = throwable; }
	public void setSize(Integer size) { this.size = size; }
	public void setRtt(Integer rtt) { this.rtt = rtt; }
	public void setTtl(Integer ttl) { this.ttl = ttl; }
	public void setDuration(Integer duration) { this.duration = duration; }
	public void setMeasuredAt(ZonedDateTime measuredAt) { this.measuredAt = measuredAt; }

}