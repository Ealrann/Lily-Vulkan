package org.sheepy.lily.vulkan.model.process;

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
import org.sheepy.lily.core.model.types.LNamedElement;
import org.sheepy.lily.core.model.types.TypesModelDefinition;
import org.sheepy.lily.vulkan.model.process.builder.BindDescriptorSetsBuilder;
import org.sheepy.lily.vulkan.model.process.builder.CompositePipelineBuilder;
import org.sheepy.lily.vulkan.model.process.builder.CompositeTaskBuilder;
import org.sheepy.lily.vulkan.model.process.builder.CopyBufferTaskBuilder;
import org.sheepy.lily.vulkan.model.process.builder.FetchBufferBuilder;
import org.sheepy.lily.vulkan.model.process.builder.FlushTransferBufferTaskBuilder;
import org.sheepy.lily.vulkan.model.process.builder.PipelineBarrierBuilder;
import org.sheepy.lily.vulkan.model.process.builder.PipelineBuilder;
import org.sheepy.lily.vulkan.model.process.builder.PipelineExtensionPkgBuilder;
import org.sheepy.lily.vulkan.model.process.builder.PipelinePkgBuilder;
import org.sheepy.lily.vulkan.model.process.builder.ProcessExtensionPkgBuilder;
import org.sheepy.lily.vulkan.model.process.builder.PushConstantBufferBuilder;
import org.sheepy.lily.vulkan.model.process.builder.SubmissionBuilder;
import org.sheepy.lily.vulkan.model.process.builder.TaskPkgBuilder;
import org.sheepy.lily.vulkan.model.vulkan.IProcess;
import org.sheepy.lily.vulkan.model.vulkan.IResourceContainer;
import org.sheepy.lily.vulkan.model.vulkan.VulkanModelDefinition;

public interface ProcessModelDefinition {
  interface Generics {
  }

  interface Groups {
    Group<IProcessExtension> I_PROCESS_EXTENSION = new GroupBuilder<IProcessExtension>().name("IProcessExtension").addFeatures(IProcessExtension.Features.ALL).build();
    Group<ProcessExtensionPkg> PROCESS_EXTENSION_PKG = new GroupBuilder<ProcessExtensionPkg>().name("ProcessExtensionPkg").concrete(true).addFeatures(ProcessExtensionPkg.Features.ALL).lmBuilder(new BuilderSupplier<>(ProcessExtensionPkgBuilder::new)).build();
    Group<IPipelineExtension> I_PIPELINE_EXTENSION = new GroupBuilder<IPipelineExtension>().name("IPipelineExtension").addFeatures(IPipelineExtension.Features.ALL).build();
    Group<PipelineExtensionPkg> PIPELINE_EXTENSION_PKG = new GroupBuilder<PipelineExtensionPkg>().name("PipelineExtensionPkg").concrete(true).addFeatures(PipelineExtensionPkg.Features.ALL).lmBuilder(new BuilderSupplier<>(PipelineExtensionPkgBuilder::new)).build();
    Group<ProcessConfiguration> PROCESS_CONFIGURATION = new GroupBuilder<ProcessConfiguration>().name("ProcessConfiguration").addFeatures(ProcessConfiguration.Features.ALL).build();
    Group<IExecutionAcquirer> I_EXECUTION_ACQUIRER = new GroupBuilder<IExecutionAcquirer>().name("IExecutionAcquirer").addFeatures(IExecutionAcquirer.Features.ALL).build();
    Group<ProcessExecutionManager> PROCESS_EXECUTION_MANAGER = new GroupBuilder<ProcessExecutionManager>().name("ProcessExecutionManager").addFeatures(ProcessExecutionManager.Features.ALL).build();
    Group<Submission> SUBMISSION = new GroupBuilder<Submission>().name("Submission").concrete(true).addFeatures(Submission.Features.ALL).lmBuilder(new BuilderSupplier<>(SubmissionBuilder::new)).build();
    Group<ExecutionRecorder> EXECUTION_RECORDER = new GroupBuilder<ExecutionRecorder>().name("ExecutionRecorder").addFeatures(ExecutionRecorder.Features.ALL).build();
    Group<ICommandBuffer> I_COMMAND_BUFFER = new GroupBuilder<ICommandBuffer>().name("ICommandBuffer").addFeatures(ICommandBuffer.Features.ALL).build();
    Group<IPipelineTask> I_PIPELINE_TASK = new GroupBuilder<IPipelineTask>().name("IPipelineTask").addInclude(() -> new IncludeBuilder<LNamedElement>().group(() -> TypesModelDefinition.Groups.L_NAMED_ELEMENT).build()).addFeatures(IPipelineTask.Features.ALL).build();
    Group<AbstractPipeline> ABSTRACT_PIPELINE = new GroupBuilder<AbstractPipeline>().name("AbstractPipeline").addInclude(() -> new IncludeBuilder<LNamedElement>().group(() -> TypesModelDefinition.Groups.L_NAMED_ELEMENT).build()).addFeatures(AbstractPipeline.Features.ALL).build();
    Group<TaskPipeline> TASK_PIPELINE = new GroupBuilder<TaskPipeline>().name("TaskPipeline").addInclude(() -> new IncludeBuilder<AbstractPipeline>().group(() -> ABSTRACT_PIPELINE).build()).addInclude(() -> new IncludeBuilder<IResourceContainer>().group(() -> VulkanModelDefinition.Groups.I_RESOURCE_CONTAINER).build()).addFeatures(TaskPipeline.Features.ALL).build();
    Group<VkPipeline> VK_PIPELINE = new GroupBuilder<VkPipeline>().name("VkPipeline").addInclude(() -> new IncludeBuilder<TaskPipeline>().group(() -> TASK_PIPELINE).build()).addFeatures(VkPipeline.Features.ALL).build();
    Group<PipelinePkg> PIPELINE_PKG = new GroupBuilder<PipelinePkg>().name("PipelinePkg").concrete(true).addFeatures(PipelinePkg.Features.ALL).lmBuilder(new BuilderSupplier<>(PipelinePkgBuilder::new)).build();
    Group<TaskPkg> TASK_PKG = new GroupBuilder<TaskPkg>().name("TaskPkg").concrete(true).addFeatures(TaskPkg.Features.ALL).lmBuilder(new BuilderSupplier<>(TaskPkgBuilder::new)).build();
    Group<Pipeline> PIPELINE = new GroupBuilder<Pipeline>().name("Pipeline").concrete(true).addInclude(() -> new IncludeBuilder<TaskPipeline>().group(() -> TASK_PIPELINE).build()).addFeatures(Pipeline.Features.ALL).lmBuilder(new BuilderSupplier<>(PipelineBuilder::new)).build();
    Group<CompositePipeline> COMPOSITE_PIPELINE = new GroupBuilder<CompositePipeline>().name("CompositePipeline").concrete(true).addInclude(() -> new IncludeBuilder<AbstractPipeline>().group(() -> ABSTRACT_PIPELINE).build()).addFeatures(CompositePipeline.Features.ALL).lmBuilder(new BuilderSupplier<>(CompositePipelineBuilder::new)).build();
    Group<CompositeTask> COMPOSITE_TASK = new GroupBuilder<CompositeTask>().name("CompositeTask").concrete(true).addInclude(() -> new IncludeBuilder<IPipelineTask>().group(() -> I_PIPELINE_TASK).build()).addInclude(() -> new IncludeBuilder<Maintainable<?>>().group(() -> MaintainerModelDefinition.Groups.MAINTAINABLE).addParameter(() -> new GenericParameterBuilder().type(() -> ProcessModelDefinition.Groups.COMPOSITE_TASK).build()).build()).addFeatures(CompositeTask.Features.ALL).lmBuilder(new BuilderSupplier<>(CompositeTaskBuilder::new)).build();
    Group<PipelineBarrier> PIPELINE_BARRIER = new GroupBuilder<PipelineBarrier>().name("PipelineBarrier").concrete(true).addInclude(() -> new IncludeBuilder<IPipelineTask>().group(() -> I_PIPELINE_TASK).build()).addFeatures(PipelineBarrier.Features.ALL).lmBuilder(new BuilderSupplier<>(PipelineBarrierBuilder::new)).build();
    Group<BindDescriptorSets> BIND_DESCRIPTOR_SETS = new GroupBuilder<BindDescriptorSets>().name("BindDescriptorSets").concrete(true).addInclude(() -> new IncludeBuilder<IPipelineTask>().group(() -> I_PIPELINE_TASK).build()).addFeatures(BindDescriptorSets.Features.ALL).lmBuilder(new BuilderSupplier<>(BindDescriptorSetsBuilder::new)).build();
    Group<PushConstant> PUSH_CONSTANT = new GroupBuilder<PushConstant>().name("PushConstant").addInclude(() -> new IncludeBuilder<IPipelineTask>().group(() -> I_PIPELINE_TASK).build()).addFeatures(PushConstant.Features.ALL).build();
    Group<PushConstantBuffer> PUSH_CONSTANT_BUFFER = new GroupBuilder<PushConstantBuffer>().name("PushConstantBuffer").concrete(true).addInclude(() -> new IncludeBuilder<PushConstant>().group(() -> PUSH_CONSTANT).build()).addFeatures(PushConstantBuffer.Features.ALL).lmBuilder(new BuilderSupplier<>(PushConstantBufferBuilder::new)).build();
    Group<FlushTransferBufferTask> FLUSH_TRANSFER_BUFFER_TASK = new GroupBuilder<FlushTransferBufferTask>().name("FlushTransferBufferTask").concrete(true).addInclude(() -> new IncludeBuilder<IPipelineTask>().group(() -> I_PIPELINE_TASK).build()).addFeatures(FlushTransferBufferTask.Features.ALL).lmBuilder(new BuilderSupplier<>(FlushTransferBufferTaskBuilder::new)).build();
    Group<CopyBufferTask> COPY_BUFFER_TASK = new GroupBuilder<CopyBufferTask>().name("CopyBufferTask").concrete(true).addInclude(() -> new IncludeBuilder<IPipelineTask>().group(() -> I_PIPELINE_TASK).build()).addFeatures(CopyBufferTask.Features.ALL).lmBuilder(new BuilderSupplier<>(CopyBufferTaskBuilder::new)).build();
    Group<FetchBuffer> FETCH_BUFFER = new GroupBuilder<FetchBuffer>().name("FetchBuffer").concrete(true).addInclude(() -> new IncludeBuilder<IPipelineTask>().group(() -> I_PIPELINE_TASK).build()).addFeatures(FetchBuffer.Features.ALL).lmBuilder(new BuilderSupplier<>(FetchBufferBuilder::new)).build();
    Group<AbstractProcess> ABSTRACT_PROCESS = new GroupBuilder<AbstractProcess>().name("AbstractProcess").addInclude(() -> new IncludeBuilder<IProcess>().group(() -> VulkanModelDefinition.Groups.I_PROCESS).build()).addFeatures(AbstractProcess.Features.ALL).build();
    List<Group<?>> ALL = List.of(I_PROCESS_EXTENSION, PROCESS_EXTENSION_PKG, I_PIPELINE_EXTENSION, PIPELINE_EXTENSION_PKG, PROCESS_CONFIGURATION, I_EXECUTION_ACQUIRER, PROCESS_EXECUTION_MANAGER, SUBMISSION, EXECUTION_RECORDER, I_COMMAND_BUFFER, I_PIPELINE_TASK, ABSTRACT_PIPELINE, TASK_PIPELINE, VK_PIPELINE, PIPELINE_PKG, TASK_PKG, PIPELINE, COMPOSITE_PIPELINE, COMPOSITE_TASK, PIPELINE_BARRIER, BIND_DESCRIPTOR_SETS, PUSH_CONSTANT, PUSH_CONSTANT_BUFFER, FLUSH_TRANSFER_BUFFER_TASK, COPY_BUFFER_TASK, FETCH_BUFFER, ABSTRACT_PROCESS);
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
