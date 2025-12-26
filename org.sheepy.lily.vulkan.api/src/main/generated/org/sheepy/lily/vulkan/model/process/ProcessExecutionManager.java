package org.sheepy.lily.vulkan.model.process;

import java.util.List;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.notification.listener.Listener;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.Feature;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.Relation;
import org.logoce.lmf.core.lang.builder.AttributeBuilder;
import org.logoce.lmf.core.lang.builder.RelationBuilder;
import org.sheepy.vulkan.model.enumeration.EPipelineStage;
import org.sheepy.vulkan.model.enumeration.EnumerationModelDefinition;

public interface ProcessExecutionManager extends LMObject {
  @Override
  IModelNotifier<? extends Features<?>> notifier();
  List<ProcessExecutionManager> waitForExecution();
  List<ProcessExecutionManager> waitedBy();
  EPipelineStage waitStage();
  IExecutionAcquirer acquirer();
  void waitStage(final EPipelineStage waitStage);
  void acquirer(final IExecutionAcquirer acquirer);

  interface FeatureIDs {
    int WAIT_FOR_EXECUTION = 404379163;
    int WAITED_BY = 2000676610;
    int WAIT_STAGE = 1875315378;
    int ACQUIRER = 23685395;
  }

  interface Features<T extends Features<T>> extends LMObject.Features<T> {
    Relation<ProcessExecutionManager, List<ProcessExecutionManager>, Listener<List<ProcessExecutionManager>>, Features<?>> WAIT_FOR_EXECUTION = new RelationBuilder<ProcessExecutionManager, List<ProcessExecutionManager>, Listener<List<ProcessExecutionManager>>, Features<?>>().name("waitForExecution").immutable(true).many(true).lazy(true).id(ProcessExecutionManager.FeatureIDs.WAIT_FOR_EXECUTION).concept(() -> ProcessModelDefinition.Groups.PROCESS_EXECUTION_MANAGER).build();
    Relation<ProcessExecutionManager, List<ProcessExecutionManager>, Listener<List<ProcessExecutionManager>>, Features<?>> WAITED_BY = new RelationBuilder<ProcessExecutionManager, List<ProcessExecutionManager>, Listener<List<ProcessExecutionManager>>, Features<?>>().name("waitedBy").immutable(true).many(true).lazy(true).id(ProcessExecutionManager.FeatureIDs.WAITED_BY).concept(() -> ProcessModelDefinition.Groups.PROCESS_EXECUTION_MANAGER).build();
    Attribute<EPipelineStage, EPipelineStage, Listener<EPipelineStage>, Features<?>> WAIT_STAGE = new AttributeBuilder<EPipelineStage, EPipelineStage, Listener<EPipelineStage>, Features<?>>().name("waitStage").id(ProcessExecutionManager.FeatureIDs.WAIT_STAGE).datatype(() -> EnumerationModelDefinition.Enums.E_PIPELINE_STAGE).build();
    Relation<IExecutionAcquirer, IExecutionAcquirer, Listener<IExecutionAcquirer>, Features<?>> ACQUIRER = new RelationBuilder<IExecutionAcquirer, IExecutionAcquirer, Listener<IExecutionAcquirer>, Features<?>>().name("acquirer").contains(true).id(ProcessExecutionManager.FeatureIDs.ACQUIRER).concept(() -> ProcessModelDefinition.Groups.I_EXECUTION_ACQUIRER).build();
    List<Feature<?, ?, ?, ?>> ALL = List.of(WAIT_FOR_EXECUTION, WAITED_BY, WAIT_STAGE, ACQUIRER);
  }
}
