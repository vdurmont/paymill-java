package com.paymill.models;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * A transaction is the charging of a credit card or a direct debit. In this case you need a new transaction object with either a
 * valid token, payment, client + payment or preauthorization. Every transaction has a unique identifier which will be generated
 * by PAYMILL to identify every transaction. You can issue/create, list and display transactions in detail. Refunds can be done in
 * an extra entity.
 * @author Vassil Nikolov
 * @since 3.0.0
 */
@JsonIgnoreProperties( ignoreUnknown = true )
public final class Transaction {

  private String             id;

  private Integer            amount;

  @JsonProperty( "origin_amount" )
  private Integer            originAmount;

  private String             currency;

  private Transaction.Status status;

  @Updateable( "description" )
  private String             description;

  private Boolean            livemode;

  private List<Refund>       refunds;

  private Payment            payment;

  private Client             client;

  private Preauthorization   preauthorization;

  @JsonProperty( "created_at" )
  private Date               createdAt;

  @JsonProperty( "updated_at" )
  private Date               updatedAt;

  @JsonProperty( "response_code" )
  private String             responseCode;

  @JsonProperty( "short_id" )
  private String             shortId;

  @JsonProperty( "is_fraud" )
  private Boolean            fraud;

  private List<Fee>          fees;

  @JsonProperty( "app_id" )
  private String             appId;

  public Transaction() {
    super();
  }

  public Transaction( final String id ) {
    this.id = id;
  }

  public String getId() {
    return this.id;
  }

  public void setId( final String id ) {
    this.id = id;
  }

  public Integer getAmount() {
    return this.amount;
  }

  public void setAmount( final Integer amount ) {
    this.amount = amount;
  }

  public Integer getOriginAmount() {
    return this.originAmount;
  }

  public void setOriginAmount( final Integer originAmount ) {
    this.originAmount = originAmount;
  }

  public String getCurrency() {
    return this.currency;
  }

  public void setCurrency( final String currency ) {
    this.currency = currency;
  }

  public Transaction.Status getStatus() {
    return this.status;
  }

  public void setStatus( final Transaction.Status status ) {
    this.status = status;
  }

  public String getDescription() {
    return this.description;
  }

  public void setDescription( final String description ) {
    this.description = description;
  }

  public Boolean getLivemode() {
    return this.livemode;
  }

  public void setLivemode( final Boolean livemode ) {
    this.livemode = livemode;
  }

  public List<Refund> getRefunds() {
    return this.refunds;
  }

  public void setRefunds( final List<Refund> refunds ) {
    this.refunds = refunds;
  }

  public Payment getPayment() {
    return this.payment;
  }

  public void setPayment( final Payment payment ) {
    this.payment = payment;
  }

  public Client getClient() {
    return this.client;
  }

  public void setClient( final Client client ) {
    this.client = client;
  }

  public Preauthorization getPreauthorization() {
    return this.preauthorization;
  }

  public void setPreauthorization( final Preauthorization preauthorization ) {
    this.preauthorization = preauthorization;
  }

  public String getResponseCode() {
    return this.responseCode;
  }

  public void setResponseCode( final String responseCode ) {
    this.responseCode = responseCode;
  }

  public String getShortId() {
    return this.shortId;
  }

  public void setShortId( final String shortId ) {
    this.shortId = shortId;
  }

  public Boolean getFraud() {
    return this.fraud;
  }

  public void setFraud( final Boolean fraud ) {
    this.fraud = fraud;
  }

  public List<Fee> getFees() {
    return this.fees;
  }

  public void setFees( final List<Fee> fees ) {
    this.fees = fees;
  }

  /**
   * Returns App (ID) that created this transaction or <code>null</code> if created by yourself.
   * @return {@link String} or <code>null</code>.
   */
  public String getAppId() {
    return this.appId;
  }

  /**
   * Sets App (ID) that created this transaction or <code>null</code> if created by yourself.
   * @param appId
   *          {@link String}
   */
  public void setAppId( final String appId ) {
    this.appId = appId;
  }

  /**
   * Returns the creation date.
   * @return {@link Date}
   */
  public Date getCreatedAt() {
    return this.createdAt;
  }

  /**
   * Set the creation date.
   * @param createdAt
   *          {@link Date}
   */
  @JsonIgnore
  public void setCreatedAt( final Date createdAt ) {
    this.createdAt = createdAt;
  }

  /**
   * Set the creation date.
   * @param seconds
   *          Creation date representation is seconds.
   */
  public void setCreatedAt( final long seconds ) {
    this.createdAt = new Date( seconds * 1000 );
  }

  /**
   * Returns the last update.
   * @return {@link Date}
   */
  public Date getUpdatedAt() {
    return this.updatedAt;
  }

  /**
   * Sets the last update.
   * @param updatedAt
   *          {@link Date}
   */
  @JsonIgnore
  public void setUpdatedAt( final Date updatedAt ) {
    this.updatedAt = updatedAt;
  }

  /**
   * Sets the last update.
   * @param seconds
   *          Last update representation is seconds.
   */
  public void setUpdatedAt( final long seconds ) {
    this.updatedAt = new Date( seconds * 1000 );
  }

  public static Transaction.Filter createFilter() {
    return new Transaction.Filter();
  }

  public static Transaction.Order createOrder() {
    return new Transaction.Order();
  }

  public final static class Filter {

    @SnakeCase( "client" )
    private String clientId;

    @SnakeCase( "payment" )
    private String paymentId;

    @SnakeCase( "amount" )
    private String amount;

    @SnakeCase( "description" )
    private String description;

    @SnakeCase( "created_at" )
    private String createdAt;

    @SnakeCase( "updated_at" )
    private String updatedAt;

    @SnakeCase( "status" )
    private String status;

    private Filter() {
      super();
    }

    public Transaction.Filter byClientId( final String clientId ) {
      this.clientId = clientId;
      return this;
    }

    public Transaction.Filter byPaymentId( final String paymentId ) {
      this.paymentId = paymentId;
      return this;
    }

    public Transaction.Filter byAmount( final int amount ) {
      this.amount = String.valueOf( amount );
      return this;
    }

    public Transaction.Filter byAmountGreaterThan( final int amount ) {
      this.amount = ">" + String.valueOf( amount );
      return this;
    }

    public Transaction.Filter byAmountLessThan( final int amount ) {
      this.amount = "<" + String.valueOf( amount );
      return this;
    }

    public Transaction.Filter byDescription( final String description ) {
      this.description = description;
      return this;
    }

    public Transaction.Filter byCreatedAt( final Date startCreatedAt, final Date endCreatedAt ) {
      this.createdAt = String.valueOf( startCreatedAt.getTime() ) + "-" + String.valueOf( endCreatedAt.getTime() );
      return this;
    }

    public Transaction.Filter byUpdatedAt( final Date startCreatedAt, final Date endCreatedAt ) {
      this.updatedAt = String.valueOf( startCreatedAt.getTime() ) + "-" + String.valueOf( endCreatedAt.getTime() );
      return this;
    }

    public Transaction.Filter byStatus( final Transaction.Status status ) {
      this.status = status.getValue();
      return this;
    }
  }

  public final static class Order {

    @SnakeCase( "created_at" )
    private boolean createdAt;

    @SnakeCase( value = "asc", order = true )
    private boolean asc;

    @SnakeCase( value = "desc", order = true )
    private boolean desc;

    private Order() {
      super();
    }

    public Transaction.Order asc() {
      this.asc = true;
      this.desc = false;
      return this;
    }

    public Transaction.Order desc() {
      this.asc = false;
      this.desc = true;
      return this;
    }

    public Transaction.Order byCreatedAt() {
      this.createdAt = true;
      return this;
    }

  }

  public enum Status {

    OPEN("open"),

    PENDING("pending"),

    CLOSED("closed"),

    FAILED("failed"),

    PARTIAL_REFUNDED("partial_refunded"),

    REFUNDED("refunded"),

    PREAUTH("preauth"),

    CHARGEBACK("chargeback");

    private String value;

    private Status( final String value ) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return this.value;
    }

    @JsonCreator
    public static Status create( final String value ) {
      for( Status status : Status.values() ) {
        if( status.getValue().equals( value ) ) {
          return status;
        }
      }
      throw new IllegalArgumentException( "Invalid value for Transaction.Status" );
    }
  }

}
