package org.sheepy.lily.vulkan.model.process;

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
import org.sheepy.lily.core.model.maintainer.Maintainable;
import org.sheepy.lily.core.model.maintainer.Maintainer;
import org.sheepy.lily.vulkan.model.process.builder.CompositeTaskBuilder;

public interface CompositeTask extends IPipelineTask, Maintainable<CompositeTask> {
  static Builder builder() {
    return new CompositeTaskBuilder();
  }

  @Override
  IModelNotifier<? extends Features<?>> notifier();
  int repeatCount();
  List<IPipelineTask> tasks();
  void repeatCount(final int repeatCount);

  interface FeatureIDs {
    int MAINTAINER = Maintainable.FeatureIDs.MAINTAINER;
    int NAME = Named.FeatureIDs.NAME;
    int ENABLED = IPipelineTask.FeatureIDs.ENABLED;
    int REPEAT_COUNT = 1481148293;
    int TASKS = -781674593;
  }

  interface Features<T extends Features<T>> extends IPipelineTask.Features<T>, Maintainable.Features<T> {
    Relation<Maintainer<?>, Maintainer<?>, Listener<Maintainer<?>>, Maintainable.Features<?>> MAINTAINER = Maintainable.Features.MAINTAINER;
    Attribute<String, String, Listener<String>, Named.Features<?>> NAME = Named.Features.NAME;
    Attribute<Boolean, Boolean, BooleanListener, IPipelineTask.Features<?>> ENABLED = IPipelineTask.Features.ENABLED;
    Attribute<Integer, Integer, IntListener, Features<?>> REPEAT_COUNT = new AttributeBuilder<Integer, Integer, IntListener, Features<?>>().name("repeatCount").defaultValue("1").id(CompositeTask.FeatureIDs.REPEAT_COUNT).datatype(() -> LMCoreModelDefinition.Units.INT).build();
    Relation<IPipelineTask, List<IPipelineTask>, Listener<List<IPipelineTask>>, Features<?>> TASKS = new RelationBuilder<IPipelineTask, List<IPipelineTask>, Listener<List<IPipelineTask>>, Features<?>>().name("tasks").many(true).contains(true).id(CompositeTask.FeatureIDs.TASKS).concept(() -> ProcessModelDefinition.Groups.I_PIPELINE_TASK).build();
    List<Feature<?, ?, ?, ?>> ALL = List.of(MAINTAINER, NAME, ENABLED, REPEAT_COUNT, TASKS);
  }

  interface Builder extends IFeaturedObject.Builder<CompositeTask> {
    Builder maintainer(Supplier<Maintainer<CompositeTask>> maintainer);
    Builder name(String name);
    Builder enabled(boolean enabled);
    Builder repeatCount(int repeatCount);
    Builder addTask(Supplier<IPipelineTask> task);
    Builder addTasks(List<IPipelineTask> tasks);
  }
}
