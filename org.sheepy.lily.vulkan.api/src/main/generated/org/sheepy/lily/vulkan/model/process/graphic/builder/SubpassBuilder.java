package org.sheepy.lily.vulkan.model.process.graphic.builder;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import org.logoce.lmf.core.feature.FeatureInserter;
import org.logoce.lmf.core.feature.RelationLazyInserter;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.Relation;
import org.sheepy.lily.core.model.application.ICompositor;
import org.sheepy.lily.vulkan.model.process.PipelinePkg;
import org.sheepy.lily.vulkan.model.process.ProcessExtensionPkg;
import org.sheepy.lily.vulkan.model.process.graphic.AttachmentPkg;
import org.sheepy.lily.vulkan.model.process.graphic.AttachmentRefPkg;
import org.sheepy.lily.vulkan.model.process.graphic.Subpass;
import org.sheepy.lily.vulkan.model.process.graphic.Subpass.Builder;
import org.sheepy.lily.vulkan.model.process.graphic.impl.SubpassImpl;
import org.sheepy.lily.vulkan.model.vulkan.DescriptorPkg;
import org.sheepy.lily.vulkan.model.vulkan.VulkanResourcePkg;
import org.sheepy.vulkan.model.enumeration.EAccess;
import org.sheepy.vulkan.model.enumeration.EPipelineStage;

public final class SubpassBuilder implements Builder {
  private String name;
  private Supplier<VulkanResourcePkg> resourcePkg = () -> null;
  private Supplier<DescriptorPkg> descriptorPkg = () -> null;
  private Supplier<AttachmentRefPkg> attachmentRefPkg = () -> null;
  private Supplier<AttachmentPkg> attachmentPkg = () -> null;
  private int subpassIndex = 0;
  private Supplier<PipelinePkg> pipelinePkg = () -> null;
  private int bindPoint = 0;
  private Supplier<ICompositor> compositor = () -> null;
  private EPipelineStage waitForStage = EPipelineStage.BOTTOM_OF_PIPE_BIT;
  private EPipelineStage syncStage = EPipelineStage.TOP_OF_PIPE_BIT;
  private EPipelineStage finishStage = EPipelineStage.BOTTOM_OF_PIPE_BIT;
  private final List<EAccess> waitForAccesses = new ArrayList<>();
  private final List<EAccess> syncAccesses = new ArrayList<>();
  private final List<EAccess> finishAccesses = new ArrayList<>();
  private Supplier<ProcessExtensionPkg> extensionPkg = () -> null;
  private boolean enabled = true;

  public SubpassBuilder() {
  }

  @Override
  public SubpassBuilder name(String name) {
    this.name = name;
    return this;
  }

  @Override
  public SubpassBuilder resourcePkg(Supplier<VulkanResourcePkg> resourcePkg) {
    this.resourcePkg = resourcePkg;
    return this;
  }

  @Override
  public SubpassBuilder descriptorPkg(Supplier<DescriptorPkg> descriptorPkg) {
    this.descriptorPkg = descriptorPkg;
    return this;
  }

  @Override
  public SubpassBuilder attachmentRefPkg(Supplier<AttachmentRefPkg> attachmentRefPkg) {
    this.attachmentRefPkg = attachmentRefPkg;
    return this;
  }

  @Override
  public SubpassBuilder attachmentPkg(Supplier<AttachmentPkg> attachmentPkg) {
    this.attachmentPkg = attachmentPkg;
    return this;
  }

  @Override
  public SubpassBuilder subpassIndex(int subpassIndex) {
    this.subpassIndex = subpassIndex;
    return this;
  }

  @Override
  public SubpassBuilder pipelinePkg(Supplier<PipelinePkg> pipelinePkg) {
    this.pipelinePkg = pipelinePkg;
    return this;
  }

  @Override
  public SubpassBuilder bindPoint(int bindPoint) {
    this.bindPoint = bindPoint;
    return this;
  }

  @Override
  public SubpassBuilder compositor(Supplier<ICompositor> compositor) {
    this.compositor = compositor;
    return this;
  }

  @Override
  public SubpassBuilder waitForStage(EPipelineStage waitForStage) {
    this.waitForStage = waitForStage;
    return this;
  }

  @Override
  public SubpassBuilder syncStage(EPipelineStage syncStage) {
    this.syncStage = syncStage;
    return this;
  }

  @Override
  public SubpassBuilder finishStage(EPipelineStage finishStage) {
    this.finishStage = finishStage;
    return this;
  }

  @Override
  public SubpassBuilder addWaitForAccesse(EAccess waitForAccesse) {
    this.waitForAccesses.add(waitForAccesse);
    return this;
  }

  @Override
  public SubpassBuilder addWaitForAccesses(final List<EAccess> waitForAccesses) {
    this.waitForAccesses.addAll(waitForAccesses);
    return this;
  }

  @Override
  public SubpassBuilder addSyncAccesse(EAccess syncAccesse) {
    this.syncAccesses.add(syncAccesse);
    return this;
  }

  @Override
  public SubpassBuilder addSyncAccesses(final List<EAccess> syncAccesses) {
    this.syncAccesses.addAll(syncAccesses);
    return this;
  }

  @Override
  public SubpassBuilder addFinishAccesse(EAccess finishAccesse) {
    this.finishAccesses.add(finishAccesse);
    return this;
  }

  @Override
  public SubpassBuilder addFinishAccesses(final List<EAccess> finishAccesses) {
    this.finishAccesses.addAll(finishAccesses);
    return this;
  }

  @Override
  public SubpassBuilder extensionPkg(Supplier<ProcessExtensionPkg> extensionPkg) {
    this.extensionPkg = extensionPkg;
    return this;
  }

  @Override
  public SubpassBuilder enabled(boolean enabled) {
    this.enabled = enabled;
    return this;
  }

  @Override
  public Subpass build() {
    final var built = new SubpassImpl(name, subpassIndex, bindPoint, waitForStage, syncStage, finishStage, enabled);
    built.resourcePkg(resourcePkg.get());
    built.descriptorPkg(descriptorPkg.get());
    built.attachmentRefPkg(attachmentRefPkg.get());
    built.attachmentPkg(attachmentPkg.get());
    built.pipelinePkg(pipelinePkg.get());
    built.compositor(compositor.get());
    built.waitForAccesses().addAll(waitForAccesses);
    built.syncAccesses().addAll(syncAccesses);
    built.finishAccesses().addAll(finishAccesses);
    built.extensionPkg(extensionPkg.get());
    return built;
  }

  @Override
  public <AttributeType> void push(final Attribute<?, ?, ?, ?> attribute,
      final AttributeType value) {
    Inserters.ATTRIBUTE_INSERTER.push(this, attribute.id(), value);
  }

  @Override
  public <RelationType extends LMObject> void push(final Relation<RelationType, ?, ?, ?> relation,
      final Supplier<RelationType> supplier) {
    Inserters.RELATION_INSERTER.push(this, relation.id(), supplier);
  }

  private static final class Inserters {
    private static final FeatureInserter<SubpassBuilder> ATTRIBUTE_INSERTER = new FeatureInserter.Builder<SubpassBuilder>(10, Inserters::attributeIndex).add(Subpass.FeatureIDs.NAME, (builder, value) -> builder.name((String) value)).add(Subpass.FeatureIDs.SUBPASS_INDEX, (builder, value) -> builder.subpassIndex((int) value)).add(Subpass.FeatureIDs.BIND_POINT, (builder, value) -> builder.bindPoint((int) value)).add(Subpass.FeatureIDs.WAIT_FOR_STAGE, (builder, value) -> builder.waitForStage((EPipelineStage) value)).add(Subpass.FeatureIDs.SYNC_STAGE, (builder, value) -> builder.syncStage((EPipelineStage) value)).add(Subpass.FeatureIDs.FINISH_STAGE, (builder, value) -> builder.finishStage((EPipelineStage) value)).add(Subpass.FeatureIDs.WAIT_FOR_ACCESSES, (builder, value) -> builder.addWaitForAccesse((EAccess) value)).add(Subpass.FeatureIDs.SYNC_ACCESSES, (builder, value) -> builder.addSyncAccesse((EAccess) value)).add(Subpass.FeatureIDs.FINISH_ACCESSES, (builder, value) -> builder.addFinishAccesse((EAccess) value)).add(Subpass.FeatureIDs.ENABLED, (builder, value) -> builder.enabled((boolean) value)).build();
    private static final RelationLazyInserter<SubpassBuilder> RELATION_INSERTER = new RelationLazyInserter.Builder<SubpassBuilder>(7, Inserters::relationIndex).add(Subpass.FeatureIDs.RESOURCE_PKG, (builder, value) -> builder.resourcePkg((Supplier<VulkanResourcePkg>) value)).add(Subpass.FeatureIDs.DESCRIPTOR_PKG, (builder, value) -> builder.descriptorPkg((Supplier<DescriptorPkg>) value)).add(Subpass.FeatureIDs.ATTACHMENT_REF_PKG, (builder, value) -> builder.attachmentRefPkg((Supplier<AttachmentRefPkg>) value)).add(Subpass.FeatureIDs.ATTACHMENT_PKG, (builder, value) -> builder.attachmentPkg((Supplier<AttachmentPkg>) value)).add(Subpass.FeatureIDs.PIPELINE_PKG, (builder, value) -> builder.pipelinePkg((Supplier<PipelinePkg>) value)).add(Subpass.FeatureIDs.COMPOSITOR, (builder, value) -> builder.compositor((Supplier<ICompositor>) value)).add(Subpass.FeatureIDs.EXTENSION_PKG, (builder, value) -> builder.extensionPkg((Supplier<ProcessExtensionPkg>) value)).build();

    private static int attributeIndex(final int featureId) {
      return switch (featureId) {
        case Subpass.FeatureIDs.NAME -> 0;
        case Subpass.FeatureIDs.SUBPASS_INDEX -> 1;
        case Subpass.FeatureIDs.BIND_POINT -> 2;
        case Subpass.FeatureIDs.WAIT_FOR_STAGE -> 3;
        case Subpass.FeatureIDs.SYNC_STAGE -> 4;
        case Subpass.FeatureIDs.FINISH_STAGE -> 5;
        case Subpass.FeatureIDs.WAIT_FOR_ACCESSES -> 6;
        case Subpass.FeatureIDs.SYNC_ACCESSES -> 7;
        case Subpass.FeatureIDs.FINISH_ACCESSES -> 8;
        case Subpass.FeatureIDs.ENABLED -> 9;
        default -> throw new IllegalArgumentException("Unknown attribute featureId: " + featureId);
      };
    }

    private static int relationIndex(final int featureId) {
      return switch (featureId) {
        case Subpass.FeatureIDs.RESOURCE_PKG -> 0;
        case Subpass.FeatureIDs.DESCRIPTOR_PKG -> 1;
        case Subpass.FeatureIDs.ATTACHMENT_REF_PKG -> 2;
        case Subpass.FeatureIDs.ATTACHMENT_PKG -> 3;
        case Subpass.FeatureIDs.PIPELINE_PKG -> 4;
        case Subpass.FeatureIDs.COMPOSITOR -> 5;
        case Subpass.FeatureIDs.EXTENSION_PKG -> 6;
        default -> throw new IllegalArgumentException("Unknown relation featureId: " + featureId);
      };
    }
  }
}
