/**
 */
package org.sheepy.lily.vulkan.model.process.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.sheepy.lily.core.model.action.ActionPackage;
import org.sheepy.lily.core.model.application.ApplicationPackage;
import org.sheepy.lily.core.model.cadence.CadencePackage;
import org.sheepy.lily.core.model.inference.InferencePackage;

import org.sheepy.lily.core.model.maintainer.MaintainerPackage;
import org.sheepy.lily.core.model.presentation.PresentationPackage;
import org.sheepy.lily.core.model.resource.ResourcePackage;
import org.sheepy.lily.core.model.types.TypesPackage;

import org.sheepy.lily.core.model.ui.UiPackage;
import org.sheepy.lily.core.model.variable.VariablePackage;
import org.sheepy.lily.vulkan.model.VulkanPackage;
import org.sheepy.lily.vulkan.model.binding.BindingPackage;
import org.sheepy.lily.vulkan.model.binding.impl.BindingPackageImpl;
import org.sheepy.lily.vulkan.model.impl.VulkanPackageImpl;
import org.sheepy.lily.vulkan.model.process.AbstractPipeline;
import org.sheepy.lily.vulkan.model.process.AbstractProcess;
import org.sheepy.lily.vulkan.model.process.BindDescriptorSets;
import org.sheepy.lily.vulkan.model.process.CompositePipeline;
import org.sheepy.lily.vulkan.model.process.CompositeTask;
import org.sheepy.lily.vulkan.model.process.CopyBufferTask;
import org.sheepy.lily.vulkan.model.process.ExecutionRecorder;
import org.sheepy.lily.vulkan.model.process.FlushTransferBufferTask;
import org.sheepy.lily.vulkan.model.process.IPipelineTask;
import org.sheepy.lily.vulkan.model.process.IProcessExtension;
import org.sheepy.lily.vulkan.model.process.Pipeline;
import org.sheepy.lily.vulkan.model.process.PipelineBarrier;
import org.sheepy.lily.vulkan.model.process.PipelinePkg;
import org.sheepy.lily.vulkan.model.process.PrepareCompositeTransfer;
import org.sheepy.lily.vulkan.model.process.ProcessConfiguration;
import org.sheepy.lily.vulkan.model.process.ProcessExecutionManager;
import org.sheepy.lily.vulkan.model.process.ProcessExtensionPkg;
import org.sheepy.lily.vulkan.model.process.ProcessFactory;
import org.sheepy.lily.vulkan.model.process.ProcessPackage;
import org.sheepy.lily.vulkan.model.process.PushConstant;
import org.sheepy.lily.vulkan.model.process.PushConstantBuffer;
import org.sheepy.lily.vulkan.model.process.SwapBindingsTask;
import org.sheepy.lily.vulkan.model.process.TaskPipeline;
import org.sheepy.lily.vulkan.model.process.TaskPkg;
import org.sheepy.lily.vulkan.model.process.VkPipeline;
import org.sheepy.lily.vulkan.model.process.compute.ComputePackage;
import org.sheepy.lily.vulkan.model.process.compute.impl.ComputePackageImpl;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage;
import org.sheepy.lily.vulkan.model.process.graphic.impl.GraphicPackageImpl;
import org.sheepy.lily.vulkan.model.resource.VulkanResourcePackage;
import org.sheepy.lily.vulkan.model.resource.impl.VulkanResourcePackageImpl;
import org.sheepy.vulkan.model.barrier.BarrierPackage;

import org.sheepy.vulkan.model.enumeration.EnumerationPackage;
import org.sheepy.vulkan.model.graphicpipeline.GraphicpipelinePackage;
import org.sheepy.vulkan.model.image.ImagePackage;
import org.sheepy.vulkan.model.pipeline.PipelinePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ProcessPackageImpl extends EPackageImpl implements ProcessPackage
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass abstractProcessEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pipelinePkgEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iPipelineTaskEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass abstractPipelineEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass taskPipelineEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass vkPipelineEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass taskPkgEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pipelineEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass compositePipelineEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pipelineBarrierEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass compositeTaskEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bindDescriptorSetsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pushConstantEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pushConstantBufferEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass flushTransferBufferTaskEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass copyBufferTaskEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iProcessExtensionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass processExtensionPkgEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass prepareCompositeTransferEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass swapBindingsTaskEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass processConfigurationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass processExecutionManagerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass executionRecorderEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.sheepy.lily.vulkan.model.process.ProcessPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ProcessPackageImpl()
	{
		super(eNS_URI, ProcessFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 *
	 * <p>This method is used to initialize {@link ProcessPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ProcessPackage init()
	{
		if (isInited) return (ProcessPackage)EPackage.Registry.INSTANCE.getEPackage(ProcessPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredProcessPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		ProcessPackageImpl theProcessPackage = registeredProcessPackage instanceof ProcessPackageImpl ? (ProcessPackageImpl)registeredProcessPackage : new ProcessPackageImpl();

		isInited = true;

		// Initialize simple dependencies
		UiPackage.eINSTANCE.eClass();
		PresentationPackage.eINSTANCE.eClass();
		ApplicationPackage.eINSTANCE.eClass();
		VariablePackage.eINSTANCE.eClass();
		TypesPackage.eINSTANCE.eClass();
		InferencePackage.eINSTANCE.eClass();
		MaintainerPackage.eINSTANCE.eClass();
		CadencePackage.eINSTANCE.eClass();
		ActionPackage.eINSTANCE.eClass();
		BarrierPackage.eINSTANCE.eClass();
		EnumerationPackage.eINSTANCE.eClass();
		GraphicpipelinePackage.eINSTANCE.eClass();
		ImagePackage.eINSTANCE.eClass();
		PipelinePackage.eINSTANCE.eClass();
		ResourcePackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		Object registeredPackage = EPackage.Registry.INSTANCE.getEPackage(BindingPackage.eNS_URI);
		BindingPackageImpl theBindingPackage = (BindingPackageImpl)(registeredPackage instanceof BindingPackageImpl ? registeredPackage : BindingPackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(ComputePackage.eNS_URI);
		ComputePackageImpl theComputePackage = (ComputePackageImpl)(registeredPackage instanceof ComputePackageImpl ? registeredPackage : ComputePackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(GraphicPackage.eNS_URI);
		GraphicPackageImpl theGraphicPackage = (GraphicPackageImpl)(registeredPackage instanceof GraphicPackageImpl ? registeredPackage : GraphicPackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(VulkanResourcePackage.eNS_URI);
		VulkanResourcePackageImpl theVulkanResourcePackage = (VulkanResourcePackageImpl)(registeredPackage instanceof VulkanResourcePackageImpl ? registeredPackage : VulkanResourcePackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(VulkanPackage.eNS_URI);
		VulkanPackageImpl theVulkanPackage = (VulkanPackageImpl)(registeredPackage instanceof VulkanPackageImpl ? registeredPackage : VulkanPackage.eINSTANCE);

		// Create package meta-data objects
		theProcessPackage.createPackageContents();
		theBindingPackage.createPackageContents();
		theComputePackage.createPackageContents();
		theGraphicPackage.createPackageContents();
		theVulkanResourcePackage.createPackageContents();
		theVulkanPackage.createPackageContents();

		// Initialize created meta-data
		theProcessPackage.initializePackageContents();
		theBindingPackage.initializePackageContents();
		theComputePackage.initializePackageContents();
		theGraphicPackage.initializePackageContents();
		theVulkanResourcePackage.initializePackageContents();
		theVulkanPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theProcessPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ProcessPackage.eNS_URI, theProcessPackage);
		return theProcessPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getAbstractProcess()
	{
		return abstractProcessEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getAbstractProcess_DescriptorPool()
	{
		return (EReference)abstractProcessEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAbstractProcess_WaitingFenceDuringAcquire()
	{
		return (EAttribute)abstractProcessEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAbstractProcess_ResetAllowed()
	{
		return (EAttribute)abstractProcessEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getAbstractProcess_Signals()
	{
		return (EReference)abstractProcessEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getAbstractProcess_WaitFor()
	{
		return (EReference)abstractProcessEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getAbstractProcess_ExtensionPkg()
	{
		return (EReference)abstractProcessEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getPipelinePkg()
	{
		return pipelinePkgEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getPipelinePkg_Pipelines()
	{
		return (EReference)pipelinePkgEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getIPipelineTask()
	{
		return iPipelineTaskEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getIPipelineTask_Enabled()
	{
		return (EAttribute)iPipelineTaskEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getAbstractPipeline()
	{
		return abstractPipelineEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAbstractPipeline_Enabled()
	{
		return (EAttribute)abstractPipelineEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTaskPipeline()
	{
		return taskPipelineEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTaskPipeline_TaskPkgs()
	{
		return (EReference)taskPipelineEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getVkPipeline()
	{
		return vkPipelineEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getVkPipeline_DescriptorPool()
	{
		return (EReference)vkPipelineEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getVkPipeline_SpecializationData()
	{
		return (EReference)vkPipelineEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getVkPipeline_PushConstantRanges()
	{
		return (EReference)vkPipelineEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getVkPipeline_Layout()
	{
		return (EReference)vkPipelineEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTaskPkg()
	{
		return taskPkgEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTaskPkg_Tasks()
	{
		return (EReference)taskPkgEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTaskPkg_Stage()
	{
		return (EAttribute)taskPkgEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getPipeline()
	{
		return pipelineEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getCompositePipeline()
	{
		return compositePipelineEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCompositePipeline_Pipelines()
	{
		return (EReference)compositePipelineEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getCompositePipeline_Repeat()
	{
		return (EAttribute)compositePipelineEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getPipelineBarrier()
	{
		return pipelineBarrierEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getPipelineBarrier_Barriers()
	{
		return (EReference)pipelineBarrierEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getPipelineBarrier_SrcStage()
	{
		return (EAttribute)pipelineBarrierEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getPipelineBarrier_DstStage()
	{
		return (EAttribute)pipelineBarrierEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getPipelineBarrier_SrcQueue()
	{
		return (EReference)pipelineBarrierEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getPipelineBarrier_DstQueue()
	{
		return (EReference)pipelineBarrierEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getCompositeTask()
	{
		return compositeTaskEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getCompositeTask_RepeatCount()
	{
		return (EAttribute)compositeTaskEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCompositeTask_Tasks()
	{
		return (EReference)compositeTaskEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getBindDescriptorSets()
	{
		return bindDescriptorSetsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getBindDescriptorSets_DescriptorSets()
	{
		return (EReference)bindDescriptorSetsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getBindDescriptorSets_BindPoint()
	{
		return (EAttribute)bindDescriptorSetsEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getBindDescriptorSets_Stride()
	{
		return (EAttribute)bindDescriptorSetsEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getPushConstant()
	{
		return pushConstantEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getPushConstant_Stages()
	{
		return (EAttribute)pushConstantEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getPushConstantBuffer()
	{
		return pushConstantBufferEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getPushConstantBuffer_Buffer()
	{
		return (EReference)pushConstantBufferEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getFlushTransferBufferTask()
	{
		return flushTransferBufferTaskEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getFlushTransferBufferTask_TransferBuffer()
	{
		return (EReference)flushTransferBufferTaskEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getCopyBufferTask()
	{
		return copyBufferTaskEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCopyBufferTask_SrcBuffer()
	{
		return (EReference)copyBufferTaskEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCopyBufferTask_DstBuffer()
	{
		return (EReference)copyBufferTaskEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getCopyBufferTask_Size()
	{
		return (EAttribute)copyBufferTaskEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getIProcessExtension()
	{
		return iProcessExtensionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getProcessExtensionPkg()
	{
		return processExtensionPkgEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getProcessExtensionPkg_Extensions()
	{
		return (EReference)processExtensionPkgEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getPrepareCompositeTransfer()
	{
		return prepareCompositeTransferEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getPrepareCompositeTransfer_CompositeBuffer()
	{
		return (EReference)prepareCompositeTransferEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getPrepareCompositeTransfer_Mode()
	{
		return (EAttribute)prepareCompositeTransferEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getPrepareCompositeTransfer_PrepareDuringUpdate()
	{
		return (EAttribute)prepareCompositeTransferEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getPrepareCompositeTransfer_BufferReference()
	{
		return (EReference)prepareCompositeTransferEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getPrepareCompositeTransfer_TransferBuffer()
	{
		return (EReference)prepareCompositeTransferEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getSwapBindingsTask()
	{
		return swapBindingsTaskEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getSwapBindingsTask_Task()
	{
		return (EReference)swapBindingsTaskEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getSwapBindingsTask_DescriptorSets()
	{
		return (EReference)swapBindingsTaskEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getProcessConfiguration()
	{
		return processConfigurationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getProcessExecutionManager()
	{
		return processExecutionManagerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getExecutionRecorder()
	{
		return executionRecorderEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ProcessFactory getProcessFactory()
	{
		return (ProcessFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents()
	{
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		abstractProcessEClass = createEClass(ABSTRACT_PROCESS);
		createEReference(abstractProcessEClass, ABSTRACT_PROCESS__DESCRIPTOR_POOL);
		createEAttribute(abstractProcessEClass, ABSTRACT_PROCESS__WAITING_FENCE_DURING_ACQUIRE);
		createEAttribute(abstractProcessEClass, ABSTRACT_PROCESS__RESET_ALLOWED);
		createEReference(abstractProcessEClass, ABSTRACT_PROCESS__SIGNALS);
		createEReference(abstractProcessEClass, ABSTRACT_PROCESS__WAIT_FOR);
		createEReference(abstractProcessEClass, ABSTRACT_PROCESS__EXTENSION_PKG);

		pipelinePkgEClass = createEClass(PIPELINE_PKG);
		createEReference(pipelinePkgEClass, PIPELINE_PKG__PIPELINES);

		iPipelineTaskEClass = createEClass(IPIPELINE_TASK);
		createEAttribute(iPipelineTaskEClass, IPIPELINE_TASK__ENABLED);

		abstractPipelineEClass = createEClass(ABSTRACT_PIPELINE);
		createEAttribute(abstractPipelineEClass, ABSTRACT_PIPELINE__ENABLED);

		taskPipelineEClass = createEClass(TASK_PIPELINE);
		createEReference(taskPipelineEClass, TASK_PIPELINE__TASK_PKGS);

		vkPipelineEClass = createEClass(VK_PIPELINE);
		createEReference(vkPipelineEClass, VK_PIPELINE__DESCRIPTOR_POOL);
		createEReference(vkPipelineEClass, VK_PIPELINE__SPECIALIZATION_DATA);
		createEReference(vkPipelineEClass, VK_PIPELINE__PUSH_CONSTANT_RANGES);
		createEReference(vkPipelineEClass, VK_PIPELINE__LAYOUT);

		taskPkgEClass = createEClass(TASK_PKG);
		createEReference(taskPkgEClass, TASK_PKG__TASKS);
		createEAttribute(taskPkgEClass, TASK_PKG__STAGE);

		pipelineEClass = createEClass(PIPELINE);

		compositePipelineEClass = createEClass(COMPOSITE_PIPELINE);
		createEReference(compositePipelineEClass, COMPOSITE_PIPELINE__PIPELINES);
		createEAttribute(compositePipelineEClass, COMPOSITE_PIPELINE__REPEAT);

		pipelineBarrierEClass = createEClass(PIPELINE_BARRIER);
		createEReference(pipelineBarrierEClass, PIPELINE_BARRIER__BARRIERS);
		createEAttribute(pipelineBarrierEClass, PIPELINE_BARRIER__SRC_STAGE);
		createEAttribute(pipelineBarrierEClass, PIPELINE_BARRIER__DST_STAGE);
		createEReference(pipelineBarrierEClass, PIPELINE_BARRIER__SRC_QUEUE);
		createEReference(pipelineBarrierEClass, PIPELINE_BARRIER__DST_QUEUE);

		compositeTaskEClass = createEClass(COMPOSITE_TASK);
		createEAttribute(compositeTaskEClass, COMPOSITE_TASK__REPEAT_COUNT);
		createEReference(compositeTaskEClass, COMPOSITE_TASK__TASKS);

		bindDescriptorSetsEClass = createEClass(BIND_DESCRIPTOR_SETS);
		createEReference(bindDescriptorSetsEClass, BIND_DESCRIPTOR_SETS__DESCRIPTOR_SETS);
		createEAttribute(bindDescriptorSetsEClass, BIND_DESCRIPTOR_SETS__BIND_POINT);
		createEAttribute(bindDescriptorSetsEClass, BIND_DESCRIPTOR_SETS__STRIDE);

		pushConstantEClass = createEClass(PUSH_CONSTANT);
		createEAttribute(pushConstantEClass, PUSH_CONSTANT__STAGES);

		pushConstantBufferEClass = createEClass(PUSH_CONSTANT_BUFFER);
		createEReference(pushConstantBufferEClass, PUSH_CONSTANT_BUFFER__BUFFER);

		flushTransferBufferTaskEClass = createEClass(FLUSH_TRANSFER_BUFFER_TASK);
		createEReference(flushTransferBufferTaskEClass, FLUSH_TRANSFER_BUFFER_TASK__TRANSFER_BUFFER);

		copyBufferTaskEClass = createEClass(COPY_BUFFER_TASK);
		createEAttribute(copyBufferTaskEClass, COPY_BUFFER_TASK__SIZE);
		createEReference(copyBufferTaskEClass, COPY_BUFFER_TASK__SRC_BUFFER);
		createEReference(copyBufferTaskEClass, COPY_BUFFER_TASK__DST_BUFFER);

		iProcessExtensionEClass = createEClass(IPROCESS_EXTENSION);

		processExtensionPkgEClass = createEClass(PROCESS_EXTENSION_PKG);
		createEReference(processExtensionPkgEClass, PROCESS_EXTENSION_PKG__EXTENSIONS);

		prepareCompositeTransferEClass = createEClass(PREPARE_COMPOSITE_TRANSFER);
		createEReference(prepareCompositeTransferEClass, PREPARE_COMPOSITE_TRANSFER__COMPOSITE_BUFFER);
		createEAttribute(prepareCompositeTransferEClass, PREPARE_COMPOSITE_TRANSFER__MODE);
		createEAttribute(prepareCompositeTransferEClass, PREPARE_COMPOSITE_TRANSFER__PREPARE_DURING_UPDATE);
		createEReference(prepareCompositeTransferEClass, PREPARE_COMPOSITE_TRANSFER__BUFFER_REFERENCE);
		createEReference(prepareCompositeTransferEClass, PREPARE_COMPOSITE_TRANSFER__TRANSFER_BUFFER);

		swapBindingsTaskEClass = createEClass(SWAP_BINDINGS_TASK);
		createEReference(swapBindingsTaskEClass, SWAP_BINDINGS_TASK__TASK);
		createEReference(swapBindingsTaskEClass, SWAP_BINDINGS_TASK__DESCRIPTOR_SETS);

		processConfigurationEClass = createEClass(PROCESS_CONFIGURATION);

		processExecutionManagerEClass = createEClass(PROCESS_EXECUTION_MANAGER);

		executionRecorderEClass = createEClass(EXECUTION_RECORDER);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents()
	{
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		VulkanPackage theVulkanPackage = (VulkanPackage)EPackage.Registry.INSTANCE.getEPackage(VulkanPackage.eNS_URI);
		VulkanResourcePackage theVulkanResourcePackage = (VulkanResourcePackage)EPackage.Registry.INSTANCE.getEPackage(VulkanResourcePackage.eNS_URI);
		TypesPackage theTypesPackage = (TypesPackage)EPackage.Registry.INSTANCE.getEPackage(TypesPackage.eNS_URI);
		PipelinePackage thePipelinePackage = (PipelinePackage)EPackage.Registry.INSTANCE.getEPackage(PipelinePackage.eNS_URI);
		EnumerationPackage theEnumerationPackage = (EnumerationPackage)EPackage.Registry.INSTANCE.getEPackage(EnumerationPackage.eNS_URI);
		BarrierPackage theBarrierPackage = (BarrierPackage)EPackage.Registry.INSTANCE.getEPackage(BarrierPackage.eNS_URI);
		MaintainerPackage theMaintainerPackage = (MaintainerPackage)EPackage.Registry.INSTANCE.getEPackage(MaintainerPackage.eNS_URI);
		CadencePackage theCadencePackage = (CadencePackage)EPackage.Registry.INSTANCE.getEPackage(CadencePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		abstractProcessEClass.getESuperTypes().add(theVulkanPackage.getIProcess());
		iPipelineTaskEClass.getESuperTypes().add(theTypesPackage.getLNamedElement());
		abstractPipelineEClass.getESuperTypes().add(theTypesPackage.getLNamedElement());
		taskPipelineEClass.getESuperTypes().add(this.getAbstractPipeline());
		taskPipelineEClass.getESuperTypes().add(theVulkanPackage.getIResourceContainer());
		vkPipelineEClass.getESuperTypes().add(this.getTaskPipeline());
		pipelineEClass.getESuperTypes().add(this.getTaskPipeline());
		compositePipelineEClass.getESuperTypes().add(this.getAbstractPipeline());
		pipelineBarrierEClass.getESuperTypes().add(this.getIPipelineTask());
		EGenericType g1 = createEGenericType(this.getIPipelineTask());
		compositeTaskEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(theMaintainerPackage.getMaintainable());
		EGenericType g2 = createEGenericType(this.getCompositeTask());
		g1.getETypeArguments().add(g2);
		compositeTaskEClass.getEGenericSuperTypes().add(g1);
		bindDescriptorSetsEClass.getESuperTypes().add(this.getIPipelineTask());
		pushConstantEClass.getESuperTypes().add(this.getIPipelineTask());
		pushConstantBufferEClass.getESuperTypes().add(this.getPushConstant());
		flushTransferBufferTaskEClass.getESuperTypes().add(this.getIPipelineTask());
		copyBufferTaskEClass.getESuperTypes().add(this.getIPipelineTask());
		prepareCompositeTransferEClass.getESuperTypes().add(this.getIPipelineTask());
		swapBindingsTaskEClass.getESuperTypes().add(theCadencePackage.getICadenceTask());

		// Initialize classes, features, and operations; add parameters
		initEClass(abstractProcessEClass, AbstractProcess.class, "AbstractProcess", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAbstractProcess_DescriptorPool(), theVulkanResourcePackage.getDescriptorPool(), null, "descriptorPool", null, 1, 1, AbstractProcess.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAbstractProcess_WaitingFenceDuringAcquire(), ecorePackage.getEBoolean(), "waitingFenceDuringAcquire", "false", 0, 1, AbstractProcess.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAbstractProcess_ResetAllowed(), ecorePackage.getEBoolean(), "resetAllowed", null, 0, 1, AbstractProcess.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAbstractProcess_Signals(), theVulkanResourcePackage.getSemaphore(), null, "signals", null, 0, -1, AbstractProcess.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAbstractProcess_WaitFor(), theVulkanResourcePackage.getSemaphore(), null, "waitFor", null, 0, -1, AbstractProcess.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAbstractProcess_ExtensionPkg(), this.getProcessExtensionPkg(), null, "extensionPkg", null, 0, 1, AbstractProcess.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(pipelinePkgEClass, PipelinePkg.class, "PipelinePkg", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPipelinePkg_Pipelines(), this.getAbstractPipeline(), null, "pipelines", null, 0, -1, PipelinePkg.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(iPipelineTaskEClass, IPipelineTask.class, "IPipelineTask", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIPipelineTask_Enabled(), ecorePackage.getEBoolean(), "enabled", "true", 0, 1, IPipelineTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(abstractPipelineEClass, AbstractPipeline.class, "AbstractPipeline", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAbstractPipeline_Enabled(), ecorePackage.getEBoolean(), "enabled", "true", 0, 1, AbstractPipeline.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(taskPipelineEClass, TaskPipeline.class, "TaskPipeline", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTaskPipeline_TaskPkgs(), this.getTaskPkg(), null, "taskPkgs", null, 0, -1, TaskPipeline.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(vkPipelineEClass, VkPipeline.class, "VkPipeline", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getVkPipeline_DescriptorPool(), theVulkanResourcePackage.getDescriptorPool(), null, "descriptorPool", null, 0, 1, VkPipeline.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getVkPipeline_SpecializationData(), theVulkanResourcePackage.getConstantBuffer(), null, "specializationData", null, 0, 1, VkPipeline.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getVkPipeline_PushConstantRanges(), thePipelinePackage.getPushConstantRange(), null, "pushConstantRanges", null, 0, -1, VkPipeline.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getVkPipeline_Layout(), theVulkanResourcePackage.getDescriptorSet(), null, "layout", null, 0, -1, VkPipeline.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(taskPkgEClass, TaskPkg.class, "TaskPkg", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTaskPkg_Tasks(), this.getIPipelineTask(), null, "tasks", null, 0, -1, TaskPkg.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTaskPkg_Stage(), theEnumerationPackage.getECommandStage(), "stage", "Main", 1, 1, TaskPkg.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(pipelineEClass, Pipeline.class, "Pipeline", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(compositePipelineEClass, CompositePipeline.class, "CompositePipeline", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCompositePipeline_Pipelines(), this.getTaskPipeline(), null, "pipelines", null, 0, -1, CompositePipeline.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCompositePipeline_Repeat(), ecorePackage.getEInt(), "repeat", "1", 1, 1, CompositePipeline.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(pipelineBarrierEClass, PipelineBarrier.class, "PipelineBarrier", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPipelineBarrier_Barriers(), theBarrierPackage.getBarrier(), null, "barriers", null, 1, -1, PipelineBarrier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPipelineBarrier_SrcStage(), theEnumerationPackage.getEPipelineStage(), "srcStage", null, 0, 1, PipelineBarrier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPipelineBarrier_DstStage(), theEnumerationPackage.getEPipelineStage(), "dstStage", null, 0, 1, PipelineBarrier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPipelineBarrier_SrcQueue(), this.getAbstractProcess(), null, "srcQueue", null, 0, 1, PipelineBarrier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPipelineBarrier_DstQueue(), this.getAbstractProcess(), null, "dstQueue", null, 0, 1, PipelineBarrier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(compositeTaskEClass, CompositeTask.class, "CompositeTask", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCompositeTask_RepeatCount(), ecorePackage.getEInt(), "repeatCount", "1", 0, 1, CompositeTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCompositeTask_Tasks(), this.getIPipelineTask(), null, "tasks", null, 0, -1, CompositeTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(bindDescriptorSetsEClass, BindDescriptorSets.class, "BindDescriptorSets", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBindDescriptorSets_DescriptorSets(), theVulkanResourcePackage.getDescriptorSet(), null, "descriptorSets", null, 0, -1, BindDescriptorSets.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBindDescriptorSets_BindPoint(), theEnumerationPackage.getEBindPoint(), "bindPoint", null, 1, 1, BindDescriptorSets.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBindDescriptorSets_Stride(), ecorePackage.getEInt(), "stride", "0", 0, 1, BindDescriptorSets.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(pushConstantEClass, PushConstant.class, "PushConstant", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPushConstant_Stages(), theEnumerationPackage.getEShaderStage(), "stages", null, 1, -1, PushConstant.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(pushConstantBufferEClass, PushConstantBuffer.class, "PushConstantBuffer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPushConstantBuffer_Buffer(), theVulkanResourcePackage.getConstantBuffer(), null, "buffer", null, 1, 1, PushConstantBuffer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(flushTransferBufferTaskEClass, FlushTransferBufferTask.class, "FlushTransferBufferTask", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFlushTransferBufferTask_TransferBuffer(), theVulkanResourcePackage.getTransferBuffer(), null, "transferBuffer", null, 1, 1, FlushTransferBufferTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(copyBufferTaskEClass, CopyBufferTask.class, "CopyBufferTask", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCopyBufferTask_Size(), ecorePackage.getELong(), "size", null, 0, 1, CopyBufferTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCopyBufferTask_SrcBuffer(), theVulkanResourcePackage.getIBuffer(), null, "srcBuffer", null, 1, 1, CopyBufferTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCopyBufferTask_DstBuffer(), theVulkanResourcePackage.getIBuffer(), null, "dstBuffer", null, 1, 1, CopyBufferTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(iProcessExtensionEClass, IProcessExtension.class, "IProcessExtension", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(processExtensionPkgEClass, ProcessExtensionPkg.class, "ProcessExtensionPkg", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getProcessExtensionPkg_Extensions(), this.getIProcessExtension(), null, "extensions", null, 0, -1, ProcessExtensionPkg.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(prepareCompositeTransferEClass, PrepareCompositeTransfer.class, "PrepareCompositeTransfer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPrepareCompositeTransfer_CompositeBuffer(), theVulkanResourcePackage.getCompositeBuffer(), null, "compositeBuffer", null, 1, 1, PrepareCompositeTransfer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPrepareCompositeTransfer_Mode(), theVulkanResourcePackage.getEFlushMode(), "mode", "PUSH", 1, 1, PrepareCompositeTransfer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPrepareCompositeTransfer_PrepareDuringUpdate(), ecorePackage.getEBoolean(), "prepareDuringUpdate", "false", 1, 1, PrepareCompositeTransfer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPrepareCompositeTransfer_BufferReference(), theVulkanResourcePackage.getIBufferReference(), null, "bufferReference", null, 1, 1, PrepareCompositeTransfer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPrepareCompositeTransfer_TransferBuffer(), theVulkanResourcePackage.getTransferBuffer(), null, "transferBuffer", null, 1, 1, PrepareCompositeTransfer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(swapBindingsTaskEClass, SwapBindingsTask.class, "SwapBindingsTask", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSwapBindingsTask_Task(), this.getBindDescriptorSets(), null, "task", null, 1, 1, SwapBindingsTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSwapBindingsTask_DescriptorSets(), theVulkanResourcePackage.getDescriptorSet(), null, "descriptorSets", null, 1, -1, SwapBindingsTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(processConfigurationEClass, ProcessConfiguration.class, "ProcessConfiguration", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(processExecutionManagerEClass, ProcessExecutionManager.class, "ProcessExecutionManager", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(executionRecorderEClass, ExecutionRecorder.class, "ExecutionRecorder", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //ProcessPackageImpl
