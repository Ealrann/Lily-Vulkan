package org.sheepy.lily.vulkan.model.process;

import java.util.List;
import java.util.function.Supplier;
import org.logoce.lmf.core.api.model.IFeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.notification.listener.BooleanListener;
import org.logoce.lmf.core.api.notification.listener.Listener;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.Feature;
import org.logoce.lmf.core.lang.Named;
import org.logoce.lmf.core.lang.Relation;
import org.logoce.lmf.core.lang.builder.RelationBuilder;
import org.sheepy.lily.vulkan.model.process.builder.FlushTransferBufferTaskBuilder;
import org.sheepy.lily.vulkan.model.vulkanresource.TransferBuffer;
import org.sheepy.lily.vulkan.model.vulkanresource.VulkanResourceModelDefinition;

public interface FlushTransferBufferTask extends IPipelineTask {
  static Builder builder() {
    return new FlushTransferBufferTaskBuilder();
  }

  @Override
  IModelNotifier<? extends Features<?>> notifier();
  TransferBuffer transferBuffer();
  void transferBuffer(final TransferBuffer transferBuffer);

  interface FeatureIDs {
    int NAME = Named.FeatureIDs.NAME;
    int ENABLED = IPipelineTask.FeatureIDs.ENABLED;
    int TRANSFER_BUFFER = 1439140658;
  }

  interface Features<T extends Features<T>> extends IPipelineTask.Features<T> {
    Attribute<String, String, Listener<String>, Named.Features<?>> NAME = Named.Features.NAME;
    Attribute<Boolean, Boolean, BooleanListener, IPipelineTask.Features<?>> ENABLED = IPipelineTask.Features.ENABLED;
    Relation<TransferBuffer, TransferBuffer, Listener<TransferBuffer>, Features<?>> TRANSFER_BUFFER = new RelationBuilder<TransferBuffer, TransferBuffer, Listener<TransferBuffer>, Features<?>>().name("transferBuffer").mandatory(true).id(FlushTransferBufferTask.FeatureIDs.TRANSFER_BUFFER).concept(() -> VulkanResourceModelDefinition.Groups.TRANSFER_BUFFER).build();
    List<Feature<?, ?, ?, ?>> ALL = List.of(NAME, ENABLED, TRANSFER_BUFFER);
  }

  interface Builder extends IFeaturedObject.Builder<FlushTransferBufferTask> {
    Builder name(String name);
    Builder enabled(boolean enabled);
    Builder transferBuffer(Supplier<TransferBuffer> transferBuffer);
  }
}
