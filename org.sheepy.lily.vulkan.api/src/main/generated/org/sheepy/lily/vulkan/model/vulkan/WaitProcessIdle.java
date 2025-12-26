package org.sheepy.lily.vulkan.model.vulkan;

import java.util.List;
import java.util.function.Supplier;
import org.logoce.lmf.core.api.model.IFeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.notification.listener.Listener;
import org.logoce.lmf.core.lang.Feature;
import org.logoce.lmf.core.lang.Relation;
import org.logoce.lmf.core.lang.builder.RelationBuilder;
import org.sheepy.lily.core.model.cadence.ICadenceTask;
import org.sheepy.lily.vulkan.model.vulkan.builder.WaitProcessIdleBuilder;

public interface WaitProcessIdle extends ICadenceTask {
  static Builder builder() {
    return new WaitProcessIdleBuilder();
  }

  @Override
  IModelNotifier<? extends Features<?>> notifier();
  IProcess process();

  interface FeatureIDs {
    int PROCESS = 204650858;
  }

  interface Features<T extends Features<T>> extends ICadenceTask.Features<T> {
    Relation<IProcess, IProcess, Listener<IProcess>, Features<?>> PROCESS = new RelationBuilder<IProcess, IProcess, Listener<IProcess>, Features<?>>().name("process").immutable(true).mandatory(true).lazy(true).id(WaitProcessIdle.FeatureIDs.PROCESS).concept(() -> VulkanModelDefinition.Groups.I_PROCESS).build();
    List<Feature<?, ?, ?, ?>> ALL = List.of(PROCESS);
  }

  interface Builder extends IFeaturedObject.Builder<WaitProcessIdle> {
    Builder process(Supplier<IProcess> process);
  }
}
