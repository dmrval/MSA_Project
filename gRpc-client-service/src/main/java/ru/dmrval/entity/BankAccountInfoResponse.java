// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: BankAccountInfo.proto

package ru.dmrval.entity;

/**
 * Protobuf type {@code ru.dmrval.entity.BankAccountInfoResponse}
 */
public  final class BankAccountInfoResponse extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:ru.dmrval.entity.BankAccountInfoResponse)
    BankAccountInfoResponseOrBuilder {
private static final long serialVersionUID = 0L;
  // Use BankAccountInfoResponse.newBuilder() to construct.
  private BankAccountInfoResponse(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private BankAccountInfoResponse() {
    bankAccountInfo_ = java.util.Collections.emptyList();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private BankAccountInfoResponse(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    int mutable_bitField0_ = 0;
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 10: {
            if (!((mutable_bitField0_ & 0x00000001) == 0x00000001)) {
              bankAccountInfo_ = new java.util.ArrayList<ru.dmrval.entity.BankAccountInfo>();
              mutable_bitField0_ |= 0x00000001;
            }
            bankAccountInfo_.add(
                input.readMessage(ru.dmrval.entity.BankAccountInfo.parser(), extensionRegistry));
            break;
          }
          default: {
            if (!parseUnknownFieldProto3(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      if (((mutable_bitField0_ & 0x00000001) == 0x00000001)) {
        bankAccountInfo_ = java.util.Collections.unmodifiableList(bankAccountInfo_);
      }
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return ru.dmrval.entity.BankAccountInfoOuterClass.internal_static_ru_dmrval_entity_BankAccountInfoResponse_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return ru.dmrval.entity.BankAccountInfoOuterClass.internal_static_ru_dmrval_entity_BankAccountInfoResponse_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            ru.dmrval.entity.BankAccountInfoResponse.class, ru.dmrval.entity.BankAccountInfoResponse.Builder.class);
  }

  public static final int BANKACCOUNTINFO_FIELD_NUMBER = 1;
  private java.util.List<ru.dmrval.entity.BankAccountInfo> bankAccountInfo_;
  /**
   * <code>repeated .ru.dmrval.entity.BankAccountInfo bankAccountInfo = 1;</code>
   */
  public java.util.List<ru.dmrval.entity.BankAccountInfo> getBankAccountInfoList() {
    return bankAccountInfo_;
  }
  /**
   * <code>repeated .ru.dmrval.entity.BankAccountInfo bankAccountInfo = 1;</code>
   */
  public java.util.List<? extends ru.dmrval.entity.BankAccountInfoOrBuilder> 
      getBankAccountInfoOrBuilderList() {
    return bankAccountInfo_;
  }
  /**
   * <code>repeated .ru.dmrval.entity.BankAccountInfo bankAccountInfo = 1;</code>
   */
  public int getBankAccountInfoCount() {
    return bankAccountInfo_.size();
  }
  /**
   * <code>repeated .ru.dmrval.entity.BankAccountInfo bankAccountInfo = 1;</code>
   */
  public ru.dmrval.entity.BankAccountInfo getBankAccountInfo(int index) {
    return bankAccountInfo_.get(index);
  }
  /**
   * <code>repeated .ru.dmrval.entity.BankAccountInfo bankAccountInfo = 1;</code>
   */
  public ru.dmrval.entity.BankAccountInfoOrBuilder getBankAccountInfoOrBuilder(
      int index) {
    return bankAccountInfo_.get(index);
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    for (int i = 0; i < bankAccountInfo_.size(); i++) {
      output.writeMessage(1, bankAccountInfo_.get(i));
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    for (int i = 0; i < bankAccountInfo_.size(); i++) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, bankAccountInfo_.get(i));
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof ru.dmrval.entity.BankAccountInfoResponse)) {
      return super.equals(obj);
    }
    ru.dmrval.entity.BankAccountInfoResponse other = (ru.dmrval.entity.BankAccountInfoResponse) obj;

    boolean result = true;
    result = result && getBankAccountInfoList()
        .equals(other.getBankAccountInfoList());
    result = result && unknownFields.equals(other.unknownFields);
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    if (getBankAccountInfoCount() > 0) {
      hash = (37 * hash) + BANKACCOUNTINFO_FIELD_NUMBER;
      hash = (53 * hash) + getBankAccountInfoList().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static ru.dmrval.entity.BankAccountInfoResponse parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static ru.dmrval.entity.BankAccountInfoResponse parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static ru.dmrval.entity.BankAccountInfoResponse parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static ru.dmrval.entity.BankAccountInfoResponse parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static ru.dmrval.entity.BankAccountInfoResponse parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static ru.dmrval.entity.BankAccountInfoResponse parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static ru.dmrval.entity.BankAccountInfoResponse parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static ru.dmrval.entity.BankAccountInfoResponse parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static ru.dmrval.entity.BankAccountInfoResponse parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static ru.dmrval.entity.BankAccountInfoResponse parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static ru.dmrval.entity.BankAccountInfoResponse parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static ru.dmrval.entity.BankAccountInfoResponse parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(ru.dmrval.entity.BankAccountInfoResponse prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code ru.dmrval.entity.BankAccountInfoResponse}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:ru.dmrval.entity.BankAccountInfoResponse)
      ru.dmrval.entity.BankAccountInfoResponseOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return ru.dmrval.entity.BankAccountInfoOuterClass.internal_static_ru_dmrval_entity_BankAccountInfoResponse_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return ru.dmrval.entity.BankAccountInfoOuterClass.internal_static_ru_dmrval_entity_BankAccountInfoResponse_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              ru.dmrval.entity.BankAccountInfoResponse.class, ru.dmrval.entity.BankAccountInfoResponse.Builder.class);
    }

    // Construct using ru.dmrval.entity.BankAccountInfoResponse.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
        getBankAccountInfoFieldBuilder();
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      if (bankAccountInfoBuilder_ == null) {
        bankAccountInfo_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
      } else {
        bankAccountInfoBuilder_.clear();
      }
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return ru.dmrval.entity.BankAccountInfoOuterClass.internal_static_ru_dmrval_entity_BankAccountInfoResponse_descriptor;
    }

    @java.lang.Override
    public ru.dmrval.entity.BankAccountInfoResponse getDefaultInstanceForType() {
      return ru.dmrval.entity.BankAccountInfoResponse.getDefaultInstance();
    }

    @java.lang.Override
    public ru.dmrval.entity.BankAccountInfoResponse build() {
      ru.dmrval.entity.BankAccountInfoResponse result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public ru.dmrval.entity.BankAccountInfoResponse buildPartial() {
      ru.dmrval.entity.BankAccountInfoResponse result = new ru.dmrval.entity.BankAccountInfoResponse(this);
      int from_bitField0_ = bitField0_;
      if (bankAccountInfoBuilder_ == null) {
        if (((bitField0_ & 0x00000001) == 0x00000001)) {
          bankAccountInfo_ = java.util.Collections.unmodifiableList(bankAccountInfo_);
          bitField0_ = (bitField0_ & ~0x00000001);
        }
        result.bankAccountInfo_ = bankAccountInfo_;
      } else {
        result.bankAccountInfo_ = bankAccountInfoBuilder_.build();
      }
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return (Builder) super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return (Builder) super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return (Builder) super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return (Builder) super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof ru.dmrval.entity.BankAccountInfoResponse) {
        return mergeFrom((ru.dmrval.entity.BankAccountInfoResponse)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(ru.dmrval.entity.BankAccountInfoResponse other) {
      if (other == ru.dmrval.entity.BankAccountInfoResponse.getDefaultInstance()) return this;
      if (bankAccountInfoBuilder_ == null) {
        if (!other.bankAccountInfo_.isEmpty()) {
          if (bankAccountInfo_.isEmpty()) {
            bankAccountInfo_ = other.bankAccountInfo_;
            bitField0_ = (bitField0_ & ~0x00000001);
          } else {
            ensureBankAccountInfoIsMutable();
            bankAccountInfo_.addAll(other.bankAccountInfo_);
          }
          onChanged();
        }
      } else {
        if (!other.bankAccountInfo_.isEmpty()) {
          if (bankAccountInfoBuilder_.isEmpty()) {
            bankAccountInfoBuilder_.dispose();
            bankAccountInfoBuilder_ = null;
            bankAccountInfo_ = other.bankAccountInfo_;
            bitField0_ = (bitField0_ & ~0x00000001);
            bankAccountInfoBuilder_ = 
              com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ?
                 getBankAccountInfoFieldBuilder() : null;
          } else {
            bankAccountInfoBuilder_.addAllMessages(other.bankAccountInfo_);
          }
        }
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      ru.dmrval.entity.BankAccountInfoResponse parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (ru.dmrval.entity.BankAccountInfoResponse) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private java.util.List<ru.dmrval.entity.BankAccountInfo> bankAccountInfo_ =
      java.util.Collections.emptyList();
    private void ensureBankAccountInfoIsMutable() {
      if (!((bitField0_ & 0x00000001) == 0x00000001)) {
        bankAccountInfo_ = new java.util.ArrayList<ru.dmrval.entity.BankAccountInfo>(bankAccountInfo_);
        bitField0_ |= 0x00000001;
       }
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
        ru.dmrval.entity.BankAccountInfo, ru.dmrval.entity.BankAccountInfo.Builder, ru.dmrval.entity.BankAccountInfoOrBuilder> bankAccountInfoBuilder_;

    /**
     * <code>repeated .ru.dmrval.entity.BankAccountInfo bankAccountInfo = 1;</code>
     */
    public java.util.List<ru.dmrval.entity.BankAccountInfo> getBankAccountInfoList() {
      if (bankAccountInfoBuilder_ == null) {
        return java.util.Collections.unmodifiableList(bankAccountInfo_);
      } else {
        return bankAccountInfoBuilder_.getMessageList();
      }
    }
    /**
     * <code>repeated .ru.dmrval.entity.BankAccountInfo bankAccountInfo = 1;</code>
     */
    public int getBankAccountInfoCount() {
      if (bankAccountInfoBuilder_ == null) {
        return bankAccountInfo_.size();
      } else {
        return bankAccountInfoBuilder_.getCount();
      }
    }
    /**
     * <code>repeated .ru.dmrval.entity.BankAccountInfo bankAccountInfo = 1;</code>
     */
    public ru.dmrval.entity.BankAccountInfo getBankAccountInfo(int index) {
      if (bankAccountInfoBuilder_ == null) {
        return bankAccountInfo_.get(index);
      } else {
        return bankAccountInfoBuilder_.getMessage(index);
      }
    }
    /**
     * <code>repeated .ru.dmrval.entity.BankAccountInfo bankAccountInfo = 1;</code>
     */
    public Builder setBankAccountInfo(
        int index, ru.dmrval.entity.BankAccountInfo value) {
      if (bankAccountInfoBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureBankAccountInfoIsMutable();
        bankAccountInfo_.set(index, value);
        onChanged();
      } else {
        bankAccountInfoBuilder_.setMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .ru.dmrval.entity.BankAccountInfo bankAccountInfo = 1;</code>
     */
    public Builder setBankAccountInfo(
        int index, ru.dmrval.entity.BankAccountInfo.Builder builderForValue) {
      if (bankAccountInfoBuilder_ == null) {
        ensureBankAccountInfoIsMutable();
        bankAccountInfo_.set(index, builderForValue.build());
        onChanged();
      } else {
        bankAccountInfoBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .ru.dmrval.entity.BankAccountInfo bankAccountInfo = 1;</code>
     */
    public Builder addBankAccountInfo(ru.dmrval.entity.BankAccountInfo value) {
      if (bankAccountInfoBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureBankAccountInfoIsMutable();
        bankAccountInfo_.add(value);
        onChanged();
      } else {
        bankAccountInfoBuilder_.addMessage(value);
      }
      return this;
    }
    /**
     * <code>repeated .ru.dmrval.entity.BankAccountInfo bankAccountInfo = 1;</code>
     */
    public Builder addBankAccountInfo(
        int index, ru.dmrval.entity.BankAccountInfo value) {
      if (bankAccountInfoBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureBankAccountInfoIsMutable();
        bankAccountInfo_.add(index, value);
        onChanged();
      } else {
        bankAccountInfoBuilder_.addMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .ru.dmrval.entity.BankAccountInfo bankAccountInfo = 1;</code>
     */
    public Builder addBankAccountInfo(
        ru.dmrval.entity.BankAccountInfo.Builder builderForValue) {
      if (bankAccountInfoBuilder_ == null) {
        ensureBankAccountInfoIsMutable();
        bankAccountInfo_.add(builderForValue.build());
        onChanged();
      } else {
        bankAccountInfoBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .ru.dmrval.entity.BankAccountInfo bankAccountInfo = 1;</code>
     */
    public Builder addBankAccountInfo(
        int index, ru.dmrval.entity.BankAccountInfo.Builder builderForValue) {
      if (bankAccountInfoBuilder_ == null) {
        ensureBankAccountInfoIsMutable();
        bankAccountInfo_.add(index, builderForValue.build());
        onChanged();
      } else {
        bankAccountInfoBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .ru.dmrval.entity.BankAccountInfo bankAccountInfo = 1;</code>
     */
    public Builder addAllBankAccountInfo(
        java.lang.Iterable<? extends ru.dmrval.entity.BankAccountInfo> values) {
      if (bankAccountInfoBuilder_ == null) {
        ensureBankAccountInfoIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, bankAccountInfo_);
        onChanged();
      } else {
        bankAccountInfoBuilder_.addAllMessages(values);
      }
      return this;
    }
    /**
     * <code>repeated .ru.dmrval.entity.BankAccountInfo bankAccountInfo = 1;</code>
     */
    public Builder clearBankAccountInfo() {
      if (bankAccountInfoBuilder_ == null) {
        bankAccountInfo_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
        onChanged();
      } else {
        bankAccountInfoBuilder_.clear();
      }
      return this;
    }
    /**
     * <code>repeated .ru.dmrval.entity.BankAccountInfo bankAccountInfo = 1;</code>
     */
    public Builder removeBankAccountInfo(int index) {
      if (bankAccountInfoBuilder_ == null) {
        ensureBankAccountInfoIsMutable();
        bankAccountInfo_.remove(index);
        onChanged();
      } else {
        bankAccountInfoBuilder_.remove(index);
      }
      return this;
    }
    /**
     * <code>repeated .ru.dmrval.entity.BankAccountInfo bankAccountInfo = 1;</code>
     */
    public ru.dmrval.entity.BankAccountInfo.Builder getBankAccountInfoBuilder(
        int index) {
      return getBankAccountInfoFieldBuilder().getBuilder(index);
    }
    /**
     * <code>repeated .ru.dmrval.entity.BankAccountInfo bankAccountInfo = 1;</code>
     */
    public ru.dmrval.entity.BankAccountInfoOrBuilder getBankAccountInfoOrBuilder(
        int index) {
      if (bankAccountInfoBuilder_ == null) {
        return bankAccountInfo_.get(index);  } else {
        return bankAccountInfoBuilder_.getMessageOrBuilder(index);
      }
    }
    /**
     * <code>repeated .ru.dmrval.entity.BankAccountInfo bankAccountInfo = 1;</code>
     */
    public java.util.List<? extends ru.dmrval.entity.BankAccountInfoOrBuilder> 
         getBankAccountInfoOrBuilderList() {
      if (bankAccountInfoBuilder_ != null) {
        return bankAccountInfoBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(bankAccountInfo_);
      }
    }
    /**
     * <code>repeated .ru.dmrval.entity.BankAccountInfo bankAccountInfo = 1;</code>
     */
    public ru.dmrval.entity.BankAccountInfo.Builder addBankAccountInfoBuilder() {
      return getBankAccountInfoFieldBuilder().addBuilder(
          ru.dmrval.entity.BankAccountInfo.getDefaultInstance());
    }
    /**
     * <code>repeated .ru.dmrval.entity.BankAccountInfo bankAccountInfo = 1;</code>
     */
    public ru.dmrval.entity.BankAccountInfo.Builder addBankAccountInfoBuilder(
        int index) {
      return getBankAccountInfoFieldBuilder().addBuilder(
          index, ru.dmrval.entity.BankAccountInfo.getDefaultInstance());
    }
    /**
     * <code>repeated .ru.dmrval.entity.BankAccountInfo bankAccountInfo = 1;</code>
     */
    public java.util.List<ru.dmrval.entity.BankAccountInfo.Builder> 
         getBankAccountInfoBuilderList() {
      return getBankAccountInfoFieldBuilder().getBuilderList();
    }
    private com.google.protobuf.RepeatedFieldBuilderV3<
        ru.dmrval.entity.BankAccountInfo, ru.dmrval.entity.BankAccountInfo.Builder, ru.dmrval.entity.BankAccountInfoOrBuilder> 
        getBankAccountInfoFieldBuilder() {
      if (bankAccountInfoBuilder_ == null) {
        bankAccountInfoBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<
            ru.dmrval.entity.BankAccountInfo, ru.dmrval.entity.BankAccountInfo.Builder, ru.dmrval.entity.BankAccountInfoOrBuilder>(
                bankAccountInfo_,
                ((bitField0_ & 0x00000001) == 0x00000001),
                getParentForChildren(),
                isClean());
        bankAccountInfo_ = null;
      }
      return bankAccountInfoBuilder_;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFieldsProto3(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:ru.dmrval.entity.BankAccountInfoResponse)
  }

  // @@protoc_insertion_point(class_scope:ru.dmrval.entity.BankAccountInfoResponse)
  private static final ru.dmrval.entity.BankAccountInfoResponse DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new ru.dmrval.entity.BankAccountInfoResponse();
  }

  public static ru.dmrval.entity.BankAccountInfoResponse getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<BankAccountInfoResponse>
      PARSER = new com.google.protobuf.AbstractParser<BankAccountInfoResponse>() {
    @java.lang.Override
    public BankAccountInfoResponse parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new BankAccountInfoResponse(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<BankAccountInfoResponse> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<BankAccountInfoResponse> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public ru.dmrval.entity.BankAccountInfoResponse getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

