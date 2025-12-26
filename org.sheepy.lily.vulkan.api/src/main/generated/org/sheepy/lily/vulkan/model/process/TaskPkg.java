package org.sheepy.lily.vulkan.model.process;

import java.util.List;
import java.util.function.Supplier;
import org.logoce.lmf.core.api.model.IFeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.notification.listener.Listener;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.Feature;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.Relation;
import org.logoce.lmf.core.lang.builder.AttributeBuilder;
import org.logoce.lmf.core.lang.builder.RelationBuilder;
import org.sheepy.lily.vulkan.model.process.builder.TaskPkgBuilder;
import org.sheepy.vulkan.model.enumeration.ECommandStage;
import org.sheepy.vulkan.model.enumeration.EnumerationModelDefinition;

public interface TaskPkg extends LMObject {
  static Builder builder() {
    return new TaskPkgBuilder();
  }

  @Override
  IModelNotifier<? extends Features<?>> notifier();
  List<IPipelineTask> tasks();
  ECommandStage stage();
  void stage(final ECommandStage stage);

  interface FeatureIDs {
    int TASKS = 21443578;
    int STAGE = 21068650;
  }

  interface Features<T extends Features<T>> extends LMObject.Features<T> {
    Relation<IPipelineTask, List<IPipelineTask>, Listener<List<IPipelineTask>>, Features<?>> TASKS = new RelationBuilder<IPipelineTask, List<IPipelineTask>, Listener<List<IPipelineTask>>, Features<?>>().name("tasks").many(true).contains(true).id(TaskPkg.FeatureIDs.TASKS).concept(() -> ProcessModelDefinition.Groups.I_PIPELINE_TASK).build();
    Attribute<ECommandStage, ECommandStage, Listener<ECommandStage>, Features<?>> STAGE = new AttributeBuilder<ECommandStage, ECommandStage, Listener<ECommandStage>, Features<?>>().name("stage").mandatory(true).defaultValue("MAIN").id(TaskPkg.FeatureIDs.STAGE).datatype(() -> EnumerationModelDefinition.Enums.E_COMMAND_STAGE).build();
    List<Feature<?, ?, ?, ?>> ALL = List.of(TASKS, STAGE);
  }

  interface Builder extends IFeaturedObject.Builder<TaskPkg> {
    Builder addTask(Supplier<IPipelineTask> task);
    Builder stage(ECommandStage stage);
    Builder addTasks(List<IPipelineTask> tasks);
  }
}
