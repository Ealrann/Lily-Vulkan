package org.sheepy.lily.vulkan.model.process.compute;

import java.util.List;
import org.logoce.lmf.core.api.model.BuilderSupplier;
import org.logoce.lmf.core.lang.Alias;
import org.logoce.lmf.core.lang.Enum;
import org.logoce.lmf.core.lang.Group;
import org.logoce.lmf.core.lang.JavaWrapper;
import org.logoce.lmf.core.lang.Unit;
import org.logoce.lmf.core.lang.builder.GenericParameterBuilder;
import org.logoce.lmf.core.lang.builder.GroupBuilder;
import org.logoce.lmf.core.lang.builder.IncludeBuilder;
import org.sheepy.lily.core.model.maintainer.Maintainable;
import org.sheepy.lily.core.model.maintainer.MaintainerModelDefinition;
import org.sheepy.lily.vulkan.model.process.AbstractProcess;
import org.sheepy.lily.vulkan.model.process.ExecutionRecorder;
import org.sheepy.lily.vulkan.model.process.ICommandBuffer;
import org.sheepy.lily.vulkan.model.process.IExecutionAcquirer;
import org.sheepy.lily.vulkan.model.process.IPipelineTask;
import org.sheepy.lily.vulkan.model.process.ProcessConfiguration;
import org.sheepy.lily.vulkan.model.process.ProcessExecutionManager;
import org.sheepy.lily.vulkan.model.process.ProcessModelDefinition;
import org.sheepy.lily.vulkan.model.process.VkPipeline;
import org.sheepy.lily.vulkan.model.process.compute.builder.ComputeAcquirerBuilder;
import org.sheepy.lily.vulkan.model.process.compute.builder.ComputeCommandBufferBuilder;
import org.sheepy.lily.vulkan.model.process.compute.builder.ComputeConfigurationBuilder;
import org.sheepy.lily.vulkan.model.process.compute.builder.ComputeExecutionManagerBuilder;
import org.sheepy.lily.vulkan.model.process.compute.builder.ComputeExecutionRecorderBuilder;
import org.sheepy.lily.vulkan.model.process.compute.builder.ComputePipelineBuilder;
import org.sheepy.lily.vulkan.model.process.compute.builder.ComputeProcessBuilder;
import org.sheepy.lily.vulkan.model.process.compute.builder.DispatchTaskBuilder;

public interface ComputeModelDefinition {
  interface Generics {
  }

  interface Groups {
    Group<ComputeProcess> COMPUTE_PROCESS = new GroupBuilder<ComputeProcess>().name("ComputeProcess").concrete(true).addInclude(() -> new IncludeBuilder<AbstractProcess>().group(() -> ProcessModelDefinition.Groups.ABSTRACT_PROCESS).build()).addFeatures(ComputeProcess.Features.ALL).lmBuilder(new BuilderSupplier<>(ComputeProcessBuilder::new)).build();
    Group<ComputePipeline> COMPUTE_PIPELINE = new GroupBuilder<ComputePipeline>().name("ComputePipeline").concrete(true).addInclude(() -> new IncludeBuilder<VkPipeline>().group(() -> ProcessModelDefinition.Groups.VK_PIPELINE).build()).addInclude(() -> new IncludeBuilder<Maintainable<?>>().group(() -> MaintainerModelDefinition.Groups.MAINTAINABLE).addParameter(() -> new GenericParameterBuilder().type(() -> ComputeModelDefinition.Groups.COMPUTE_PIPELINE).build()).build()).addFeatures(ComputePipeline.Features.ALL).lmBuilder(new BuilderSupplier<>(ComputePipelineBuilder::new)).build();
    Group<DispatchTask> DISPATCH_TASK = new GroupBuilder<DispatchTask>().name("DispatchTask").concrete(true).addInclude(() -> new IncludeBuilder<IPipelineTask>().group(() -> ProcessModelDefinition.Groups.I_PIPELINE_TASK).build()).addFeatures(DispatchTask.Features.ALL).lmBuilder(new BuilderSupplier<>(DispatchTaskBuilder::new)).build();
    Group<ComputeConfiguration> COMPUTE_CONFIGURATION = new GroupBuilder<ComputeConfiguration>().name("ComputeConfiguration").concrete(true).addInclude(() -> new IncludeBuilder<ProcessConfiguration>().group(() -> ProcessModelDefinition.Groups.PROCESS_CONFIGURATION).build()).addFeatures(ComputeConfiguration.Features.ALL).lmBuilder(new BuilderSupplier<>(ComputeConfigurationBuilder::new)).build();
    Group<ComputeExecutionManager> COMPUTE_EXECUTION_MANAGER = new GroupBuilder<ComputeExecutionManager>().name("ComputeExecutionManager").concrete(true).addInclude(() -> new IncludeBuilder<ProcessExecutionManager>().group(() -> ProcessModelDefinition.Groups.PROCESS_EXECUTION_MANAGER).build()).addFeatures(ComputeExecutionManager.Features.ALL).lmBuilder(new BuilderSupplier<>(ComputeExecutionManagerBuilder::new)).build();
    Group<ComputeExecutionRecorder> COMPUTE_EXECUTION_RECORDER = new GroupBuilder<ComputeExecutionRecorder>().name("ComputeExecutionRecorder").concrete(true).addInclude(() -> new IncludeBuilder<ExecutionRecorder>().group(() -> ProcessModelDefinition.Groups.EXECUTION_RECORDER).build()).addFeatures(ComputeExecutionRecorder.Features.ALL).lmBuilder(new BuilderSupplier<>(ComputeExecutionRecorderBuilder::new)).build();
    Group<ComputeCommandBuffer> COMPUTE_COMMAND_BUFFER = new GroupBuilder<ComputeCommandBuffer>().name("ComputeCommandBuffer").concrete(true).addInclude(() -> new IncludeBuilder<ICommandBuffer>().group(() -> ProcessModelDefinition.Groups.I_COMMAND_BUFFER).build()).addFeatures(ComputeCommandBuffer.Features.ALL).lmBuilder(new BuilderSupplier<>(ComputeCommandBufferBuilder::new)).build();
    Group<ComputeAcquirer> COMPUTE_ACQUIRER = new GroupBuilder<ComputeAcquirer>().name("ComputeAcquirer").concrete(true).addInclude(() -> new IncludeBuilder<IExecutionAcquirer>().group(() -> ProcessModelDefinition.Groups.I_EXECUTION_ACQUIRER).build()).addFeatures(ComputeAcquirer.Features.ALL).lmBuilder(new BuilderSupplier<>(ComputeAcquirerBuilder::new)).build();
    List<Group<?>> ALL = List.of(COMPUTE_PROCESS, COMPUTE_PIPELINE, DISPATCH_TASK, COMPUTE_CONFIGURATION, COMPUTE_EXECUTION_MANAGER, COMPUTE_EXECUTION_RECORDER, COMPUTE_COMMAND_BUFFER, COMPUTE_ACQUIRER);
  }

  interface Units {
    List<Unit<?>> ALL = List.of();
  }

  interface Enums {
    List<Enum<?>> ALL = List.of();
  }

  interface Aliases {
    List<Alias> ALL = List.of();
  }

  interface JavaWrappers {
    List<JavaWrapper<?>> ALL = List.of();
  }
}
