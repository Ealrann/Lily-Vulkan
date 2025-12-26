package org.sheepy.lily.vulkan.model.process.graphic;

import java.util.List;
import java.util.function.Supplier;
import org.logoce.lmf.core.api.model.IFeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.notification.listener.BooleanListener;
import org.logoce.lmf.core.api.notification.listener.IntListener;
import org.logoce.lmf.core.api.notification.listener.Listener;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.Feature;
import org.logoce.lmf.core.lang.LMCoreModelDefinition;
import org.logoce.lmf.core.lang.Named;
import org.logoce.lmf.core.lang.Relation;
import org.logoce.lmf.core.lang.builder.AttributeBuilder;
import org.logoce.lmf.core.lang.builder.RelationBuilder;
import org.sheepy.lily.core.model.application.ApplicationModelDefinition;
import org.sheepy.lily.core.model.application.ICompositor;
import org.sheepy.lily.core.model.types.LNamedElement;
import org.sheepy.lily.vulkan.model.process.PipelinePkg;
import org.sheepy.lily.vulkan.model.process.ProcessExtensionPkg;
import org.sheepy.lily.vulkan.model.process.ProcessModelDefinition;
import org.sheepy.lily.vulkan.model.process.graphic.builder.SubpassBuilder;
import org.sheepy.lily.vulkan.model.vulkan.DescriptorPkg;
import org.sheepy.lily.vulkan.model.vulkan.IResourceContainer;
import org.sheepy.lily.vulkan.model.vulkan.VulkanResourcePkg;
import org.sheepy.vulkan.model.enumeration.EAccess;
import org.sheepy.vulkan.model.enumeration.EPipelineStage;
import org.sheepy.vulkan.model.enumeration.EnumerationModelDefinition;

public interface Subpass extends IResourceContainer, LNamedElement {
  static Builder builder() {
    return new SubpassBuilder();
  }

  @Override
  IModelNotifier<? extends Features<?>> notifier();
  AttachmentRefPkg attachmentRefPkg();
  AttachmentPkg attachmentPkg();
  int subpassIndex();
  PipelinePkg pipelinePkg();
  int bindPoint();
  ICompositor compositor();
  EPipelineStage waitForStage();
  EPipelineStage syncStage();
  EPipelineStage finishStage();
  List<EAccess> waitForAccesses();
  List<EAccess> syncAccesses();
  List<EAccess> finishAccesses();
  ProcessExtensionPkg extensionPkg();
  boolean enabled();
  void attachmentRefPkg(final AttachmentRefPkg attachmentRefPkg);
  void attachmentPkg(final AttachmentPkg attachmentPkg);
  void subpassIndex(final int subpassIndex);
  void pipelinePkg(final PipelinePkg pipelinePkg);
  void bindPoint(final int bindPoint);
  void compositor(final ICompositor compositor);
  void waitForStage(final EPipelineStage waitForStage);
  void syncStage(final EPipelineStage syncStage);
  void finishStage(final EPipelineStage finishStage);
  void extensionPkg(final ProcessExtensionPkg extensionPkg);
  void enabled(final boolean enabled);

  interface FeatureIDs {
    int NAME = Named.FeatureIDs.NAME;
    int RESOURCE_PKG = IResourceContainer.FeatureIDs.RESOURCE_PKG;
    int DESCRIPTOR_PKG = IResourceContainer.FeatureIDs.DESCRIPTOR_PKG;
    int ATTACHMENT_REF_PKG = 1103147916;
    int ATTACHMENT_PKG = -1079653543;
    int SUBPASS_INDEX = -588551855;
    int PIPELINE_PKG = 1267941754;
    int BIND_POINT = 665213187;
    int COMPOSITOR = -2096030639;
    int WAIT_FOR_STAGE = -1888881510;
    int SYNC_STAGE = 2092702419;
    int FINISH_STAGE = 1623291867;
    int WAIT_FOR_ACCESSES = 1834881526;
    int SYNC_ACCESSES = -1205070563;
    int FINISH_ACCESSES = -1001309419;
    int EXTENSION_PKG = 898738525;
    int ENABLED = 952971505;
  }

  interface Features<T extends Features<T>> extends IResourceContainer.Features<T>, LNamedElement.Features<T> {
    Attribute<String, String, Listener<String>, Named.Features<?>> NAME = Named.Features.NAME;
    Relation<VulkanResourcePkg, VulkanResourcePkg, Listener<VulkanResourcePkg>, IResourceContainer.Features<?>> RESOURCE_PKG = IResourceContainer.Features.RESOURCE_PKG;
    Relation<DescriptorPkg, DescriptorPkg, Listener<DescriptorPkg>, IResourceContainer.Features<?>> DESCRIPTOR_PKG = IResourceContainer.Features.DESCRIPTOR_PKG;
    Relation<AttachmentRefPkg, AttachmentRefPkg, Listener<AttachmentRefPkg>, Features<?>> ATTACHMENT_REF_PKG = new RelationBuilder<AttachmentRefPkg, AttachmentRefPkg, Listener<AttachmentRefPkg>, Features<?>>().name("attachmentRefPkg").contains(true).id(Subpass.FeatureIDs.ATTACHMENT_REF_PKG).concept(() -> GraphicModelDefinition.Groups.ATTACHMENT_REF_PKG).build();
    Relation<AttachmentPkg, AttachmentPkg, Listener<AttachmentPkg>, Features<?>> ATTACHMENT_PKG = new RelationBuilder<AttachmentPkg, AttachmentPkg, Listener<AttachmentPkg>, Features<?>>().name("attachmentPkg").contains(true).id(Subpass.FeatureIDs.ATTACHMENT_PKG).concept(() -> GraphicModelDefinition.Groups.ATTACHMENT_PKG).build();
    Attribute<Integer, Integer, IntListener, Features<?>> SUBPASS_INDEX = new AttributeBuilder<Integer, Integer, IntListener, Features<?>>().name("subpassIndex").mandatory(true).defaultValue("0").id(Subpass.FeatureIDs.SUBPASS_INDEX).datatype(() -> LMCoreModelDefinition.Units.INT).build();
    Relation<PipelinePkg, PipelinePkg, Listener<PipelinePkg>, Features<?>> PIPELINE_PKG = new RelationBuilder<PipelinePkg, PipelinePkg, Listener<PipelinePkg>, Features<?>>().name("pipelinePkg").contains(true).id(Subpass.FeatureIDs.PIPELINE_PKG).concept(() -> ProcessModelDefinition.Groups.PIPELINE_PKG).build();
    Attribute<Integer, Integer, IntListener, Features<?>> BIND_POINT = new AttributeBuilder<Integer, Integer, IntListener, Features<?>>().name("bindPoint").mandatory(true).defaultValue("0").id(Subpass.FeatureIDs.BIND_POINT).datatype(() -> LMCoreModelDefinition.Units.INT).build();
    Relation<ICompositor, ICompositor, Listener<ICompositor>, Features<?>> COMPOSITOR = new RelationBuilder<ICompositor, ICompositor, Listener<ICompositor>, Features<?>>().name("compositor").id(Subpass.FeatureIDs.COMPOSITOR).concept(() -> ApplicationModelDefinition.Groups.I_COMPOSITOR).build();
    Attribute<EPipelineStage, EPipelineStage, Listener<EPipelineStage>, Features<?>> WAIT_FOR_STAGE = new AttributeBuilder<EPipelineStage, EPipelineStage, Listener<EPipelineStage>, Features<?>>().name("waitForStage").mandatory(true).defaultValue("BOTTOM_OF_PIPE_BIT").id(Subpass.FeatureIDs.WAIT_FOR_STAGE).datatype(() -> EnumerationModelDefinition.Enums.E_PIPELINE_STAGE).build();
    Attribute<EPipelineStage, EPipelineStage, Listener<EPipelineStage>, Features<?>> SYNC_STAGE = new AttributeBuilder<EPipelineStage, EPipelineStage, Listener<EPipelineStage>, Features<?>>().name("syncStage").mandatory(true).id(Subpass.FeatureIDs.SYNC_STAGE).datatype(() -> EnumerationModelDefinition.Enums.E_PIPELINE_STAGE).build();
    Attribute<EPipelineStage, EPipelineStage, Listener<EPipelineStage>, Features<?>> FINISH_STAGE = new AttributeBuilder<EPipelineStage, EPipelineStage, Listener<EPipelineStage>, Features<?>>().name("finishStage").mandatory(true).defaultValue("BOTTOM_OF_PIPE_BIT").id(Subpass.FeatureIDs.FINISH_STAGE).datatype(() -> EnumerationModelDefinition.Enums.E_PIPELINE_STAGE).build();
    Attribute<EAccess, List<EAccess>, Listener<List<EAccess>>, Features<?>> WAIT_FOR_ACCESSES = new AttributeBuilder<EAccess, List<EAccess>, Listener<List<EAccess>>, Features<?>>().name("waitForAccesses").many(true).id(Subpass.FeatureIDs.WAIT_FOR_ACCESSES).datatype(() -> EnumerationModelDefinition.Enums.E_ACCESS).build();
    Attribute<EAccess, List<EAccess>, Listener<List<EAccess>>, Features<?>> SYNC_ACCESSES = new AttributeBuilder<EAccess, List<EAccess>, Listener<List<EAccess>>, Features<?>>().name("syncAccesses").many(true).id(Subpass.FeatureIDs.SYNC_ACCESSES).datatype(() -> EnumerationModelDefinition.Enums.E_ACCESS).build();
    Attribute<EAccess, List<EAccess>, Listener<List<EAccess>>, Features<?>> FINISH_ACCESSES = new AttributeBuilder<EAccess, List<EAccess>, Listener<List<EAccess>>, Features<?>>().name("finishAccesses").many(true).id(Subpass.FeatureIDs.FINISH_ACCESSES).datatype(() -> EnumerationModelDefinition.Enums.E_ACCESS).build();
    Relation<ProcessExtensionPkg, ProcessExtensionPkg, Listener<ProcessExtensionPkg>, Features<?>> EXTENSION_PKG = new RelationBuilder<ProcessExtensionPkg, ProcessExtensionPkg, Listener<ProcessExtensionPkg>, Features<?>>().name("extensionPkg").contains(true).id(Subpass.FeatureIDs.EXTENSION_PKG).concept(() -> ProcessModelDefinition.Groups.PROCESS_EXTENSION_PKG).build();
    Attribute<Boolean, Boolean, BooleanListener, Features<?>> ENABLED = new AttributeBuilder<Boolean, Boolean, BooleanListener, Features<?>>().name("enabled").mandatory(true).defaultValue("true").id(Subpass.FeatureIDs.ENABLED).datatype(() -> LMCoreModelDefinition.Units.BOOLEAN).build();
    List<Feature<?, ?, ?, ?>> ALL = List.of(NAME, RESOURCE_PKG, DESCRIPTOR_PKG, ATTACHMENT_REF_PKG, ATTACHMENT_PKG, SUBPASS_INDEX, PIPELINE_PKG, BIND_POINT, COMPOSITOR, WAIT_FOR_STAGE, SYNC_STAGE, FINISH_STAGE, WAIT_FOR_ACCESSES, SYNC_ACCESSES, FINISH_ACCESSES, EXTENSION_PKG, ENABLED);
  }

  interface Builder extends IFeaturedObject.Builder<Subpass> {
    Builder name(String name);
    Builder resourcePkg(Supplier<VulkanResourcePkg> resourcePkg);
    Builder descriptorPkg(Supplier<DescriptorPkg> descriptorPkg);
    Builder attachmentRefPkg(Supplier<AttachmentRefPkg> attachmentRefPkg);
    Builder attachmentPkg(Supplier<AttachmentPkg> attachmentPkg);
    Builder subpassIndex(int subpassIndex);
    Builder pipelinePkg(Supplier<PipelinePkg> pipelinePkg);
    Builder bindPoint(int bindPoint);
    Builder compositor(Supplier<ICompositor> compositor);
    Builder waitForStage(EPipelineStage waitForStage);
    Builder syncStage(EPipelineStage syncStage);
    Builder finishStage(EPipelineStage finishStage);
    Builder addWaitForAccesse(EAccess waitForAccesse);
    Builder addSyncAccesse(EAccess syncAccesse);
    Builder addFinishAccesse(EAccess finishAccesse);
    Builder extensionPkg(Supplier<ProcessExtensionPkg> extensionPkg);
    Builder enabled(boolean enabled);
    Builder addWaitForAccesses(List<EAccess> waitForAccesses);
    Builder addSyncAccesses(List<EAccess> syncAccesses);
    Builder addFinishAccesses(List<EAccess> finishAccesses);
  }
}
