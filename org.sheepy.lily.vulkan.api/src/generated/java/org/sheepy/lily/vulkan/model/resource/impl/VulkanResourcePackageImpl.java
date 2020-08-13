/**
 */
package org.sheepy.lily.vulkan.model.resource.impl;

import java.nio.ByteBuffer;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
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
import org.sheepy.lily.vulkan.model.impl.VulkanPackageImpl;

import org.sheepy.lily.vulkan.model.process.ProcessPackage;

import org.sheepy.lily.vulkan.model.process.compute.ComputePackage;

import org.sheepy.lily.vulkan.model.process.compute.impl.ComputePackageImpl;

import org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage;

import org.sheepy.lily.vulkan.model.process.graphic.impl.GraphicPackageImpl;

import org.sheepy.lily.vulkan.model.process.impl.ProcessPackageImpl;
import org.sheepy.lily.vulkan.model.resource.BufferBarrier;
import org.sheepy.lily.vulkan.model.resource.BufferDataProvider;
import org.sheepy.lily.vulkan.model.resource.BufferDescriptor;
import org.sheepy.lily.vulkan.model.resource.BufferMemory;
import org.sheepy.lily.vulkan.model.resource.BufferReference;
import org.sheepy.lily.vulkan.model.resource.BufferViewer;
import org.sheepy.lily.vulkan.model.resource.CompositeImage;
import org.sheepy.lily.vulkan.model.resource.ConstantBuffer;
import org.sheepy.lily.vulkan.model.resource.DataBuffer;
import org.sheepy.lily.vulkan.model.resource.DescriptorPool;
import org.sheepy.lily.vulkan.model.resource.DescriptorSet;
import org.sheepy.lily.vulkan.model.resource.EContextIndex;
import org.sheepy.lily.vulkan.model.resource.EFlushMode;
import org.sheepy.lily.vulkan.model.resource.FileImageDataProvider;
import org.sheepy.lily.vulkan.model.resource.GenericConstantBuffer;
import org.sheepy.lily.vulkan.model.resource.IBuffer;
import org.sheepy.lily.vulkan.model.resource.IBufferObject;
import org.sheepy.lily.vulkan.model.resource.IMemoryChunkPart;
import org.sheepy.lily.vulkan.model.resource.Image;
import org.sheepy.lily.vulkan.model.resource.ImageArrayDescriptor;
import org.sheepy.lily.vulkan.model.resource.ImageBarrier;
import org.sheepy.lily.vulkan.model.resource.ImageDataProvider;
import org.sheepy.lily.vulkan.model.resource.ImageDescriptor;
import org.sheepy.lily.vulkan.model.resource.ImageInlay;
import org.sheepy.lily.vulkan.model.resource.ImageViewer;
import org.sheepy.lily.vulkan.model.resource.MemoryChunk;
import org.sheepy.lily.vulkan.model.resource.Sampler;
import org.sheepy.lily.vulkan.model.resource.SamplerDescriptor;
import org.sheepy.lily.vulkan.model.resource.Shader;
import org.sheepy.lily.vulkan.model.resource.StaticBuffer;
import org.sheepy.lily.vulkan.model.resource.StaticImage;
import org.sheepy.lily.vulkan.model.resource.TransferBuffer;
import org.sheepy.lily.vulkan.model.resource.VulkanResourceFactory;
import org.sheepy.lily.vulkan.model.resource.VulkanResourcePackage;

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
public class VulkanResourcePackageImpl extends EPackageImpl implements VulkanResourcePackage
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass transferBufferEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass descriptorPoolEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass constantBufferEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass genericConstantBufferEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iBufferEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bufferReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bufferDataProviderEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass imageDataProviderEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass fileImageDataProviderEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass imageEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass staticImageEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass imageViewerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass compositeImageEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass imageInlayEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass samplerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bufferDescriptorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass imageDescriptorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass samplerDescriptorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass descriptorSetEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bufferBarrierEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass imageBarrierEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass shaderEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass imageArrayDescriptorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass memoryChunkEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iMemoryChunkPartEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bufferMemoryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iBufferObjectEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass staticBufferEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dataBufferEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bufferViewerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum eContextIndexEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum eFlushModeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType byteBufferEDataType = null;

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
	 * @see org.sheepy.lily.vulkan.model.resource.VulkanResourcePackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private VulkanResourcePackageImpl()
	{
		super(eNS_URI, VulkanResourceFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link VulkanResourcePackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static VulkanResourcePackage init()
	{
		if (isInited) return (VulkanResourcePackage)EPackage.Registry.INSTANCE.getEPackage(VulkanResourcePackage.eNS_URI);

		// Obtain or create and register package
		Object registeredVulkanResourcePackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		VulkanResourcePackageImpl theVulkanResourcePackage = registeredVulkanResourcePackage instanceof VulkanResourcePackageImpl ? (VulkanResourcePackageImpl)registeredVulkanResourcePackage : new VulkanResourcePackageImpl();

		isInited = true;

		// Initialize simple dependencies
		ResourcePackage.eINSTANCE.eClass();
		UiPackage.eINSTANCE.eClass();
		VariablePackage.eINSTANCE.eClass();
		TypesPackage.eINSTANCE.eClass();
		PresentationPackage.eINSTANCE.eClass();
		MaintainerPackage.eINSTANCE.eClass();
		InferencePackage.eINSTANCE.eClass();
		CadencePackage.eINSTANCE.eClass();
		ActionPackage.eINSTANCE.eClass();
		ApplicationPackage.eINSTANCE.eClass();
		BarrierPackage.eINSTANCE.eClass();
		EnumerationPackage.eINSTANCE.eClass();
		GraphicpipelinePackage.eINSTANCE.eClass();
		ImagePackage.eINSTANCE.eClass();
		PipelinePackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		Object registeredPackage = EPackage.Registry.INSTANCE.getEPackage(ComputePackage.eNS_URI);
		ComputePackageImpl theComputePackage = (ComputePackageImpl)(registeredPackage instanceof ComputePackageImpl ? registeredPackage : ComputePackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(GraphicPackage.eNS_URI);
		GraphicPackageImpl theGraphicPackage = (GraphicPackageImpl)(registeredPackage instanceof GraphicPackageImpl ? registeredPackage : GraphicPackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(ProcessPackage.eNS_URI);
		ProcessPackageImpl theProcessPackage = (ProcessPackageImpl)(registeredPackage instanceof ProcessPackageImpl ? registeredPackage : ProcessPackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(VulkanPackage.eNS_URI);
		VulkanPackageImpl theVulkanPackage = (VulkanPackageImpl)(registeredPackage instanceof VulkanPackageImpl ? registeredPackage : VulkanPackage.eINSTANCE);

		// Create package meta-data objects
		theVulkanResourcePackage.createPackageContents();
		theComputePackage.createPackageContents();
		theGraphicPackage.createPackageContents();
		theProcessPackage.createPackageContents();
		theVulkanPackage.createPackageContents();

		// Initialize created meta-data
		theVulkanResourcePackage.initializePackageContents();
		theComputePackage.initializePackageContents();
		theGraphicPackage.initializePackageContents();
		theProcessPackage.initializePackageContents();
		theVulkanPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theVulkanResourcePackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(VulkanResourcePackage.eNS_URI, theVulkanResourcePackage);
		return theVulkanResourcePackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTransferBuffer()
	{
		return transferBufferEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTransferBuffer_Size()
	{
		return (EAttribute)transferBufferEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTransferBuffer_UsedToPush()
	{
		return (EAttribute)transferBufferEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTransferBuffer_UsedToFetch()
	{
		return (EAttribute)transferBufferEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDescriptorPool()
	{
		return descriptorPoolEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDescriptorPool_DescriptorSets()
	{
		return (EReference)descriptorPoolEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getConstantBuffer()
	{
		return constantBufferEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getConstantBuffer_Data()
	{
		return (EAttribute)constantBufferEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getGenericConstantBuffer()
	{
		return genericConstantBufferEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getGenericConstantBuffer_ReferencedVariables()
	{
		return (EReference)genericConstantBufferEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getGenericConstantBuffer_VariablePkg()
	{
		return (EReference)genericConstantBufferEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getIBuffer()
	{
		return iBufferEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getBufferReference()
	{
		return bufferReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getBufferReference_Buffers()
	{
		return (EReference)bufferReferenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getBufferReference_Stride()
	{
		return (EAttribute)bufferReferenceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getBufferReference_IndexType()
	{
		return (EAttribute)bufferReferenceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getBufferDataProvider()
	{
		return bufferDataProviderEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getImageDataProvider() {
		return imageDataProviderEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getFileImageDataProvider()
	{
		return fileImageDataProviderEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getFileImageDataProvider_FileImage()
	{
		return (EReference)fileImageDataProviderEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getImage()
	{
		return imageEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getStaticImage()
	{
		return staticImageEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getStaticImage_FillWithZero()
	{
		return (EAttribute)staticImageEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getStaticImage_FillWith()
	{
		return (EAttribute)staticImageEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getStaticImage_Size()
	{
		return (EAttribute)staticImageEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getImageViewer() {
		return imageViewerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getImageViewer_DataProvider() {
		return (EReference)imageViewerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getImageViewer_MipmapEnabled()
	{
		return (EAttribute)imageViewerEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getCompositeImage()
	{
		return compositeImageEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCompositeImage_Inlays()
	{
		return (EReference)compositeImageEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCompositeImage_Background()
	{
		return (EReference)compositeImageEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getImageInlay()
	{
		return imageInlayEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getImageInlay_Image()
	{
		return (EReference)imageInlayEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getImageInlay_Position()
	{
		return (EAttribute)imageInlayEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getImageInlay_Size()
	{
		return (EAttribute)imageInlayEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getImageInlay_HorizontalRelative()
	{
		return (EAttribute)imageInlayEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getImageInlay_VerticalRelative()
	{
		return (EAttribute)imageInlayEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getSampler()
	{
		return samplerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getSampler_Image()
	{
		return (EReference)samplerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getBufferDescriptor()
	{
		return bufferDescriptorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getBufferDescriptor_Buffer()
	{
		return (EReference)bufferDescriptorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getImageDescriptor()
	{
		return imageDescriptorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getImageDescriptor_Image()
	{
		return (EReference)imageDescriptorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getImageDescriptor_Sampler() {
		return (EReference)imageDescriptorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getImageDescriptor_Layout()
	{
		return (EAttribute)imageDescriptorEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getSamplerDescriptor()
	{
		return samplerDescriptorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getSamplerDescriptor_Sampler()
	{
		return (EReference)samplerDescriptorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDescriptorSet()
	{
		return descriptorSetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDescriptorSet_Descriptors()
	{
		return (EReference)descriptorSetEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getBufferBarrier()
	{
		return bufferBarrierEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getBufferBarrier_Buffers()
	{
		return (EReference)bufferBarrierEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getImageBarrier()
	{
		return imageBarrierEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getImageBarrier_Image()
	{
		return (EReference)imageBarrierEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getShader()
	{
		return shaderEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getShader_File()
	{
		return (EReference)shaderEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getShader_Stage()
	{
		return (EAttribute)shaderEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getShader_Constants()
	{
		return (EReference)shaderEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getImageArrayDescriptor()
	{
		return imageArrayDescriptorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getImageArrayDescriptor_Images()
	{
		return (EReference)imageArrayDescriptorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getImageArrayDescriptor_InitialLayout()
	{
		return (EAttribute)imageArrayDescriptorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getMemoryChunk()
	{
		return memoryChunkEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMemoryChunk_Parts()
	{
		return (EReference)memoryChunkEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMemoryChunk_TransferBuffer()
	{
		return (EReference)memoryChunkEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getIMemoryChunkPart()
	{
		return iMemoryChunkPartEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getBufferMemory()
	{
		return bufferMemoryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getBufferMemory_Buffers()
	{
		return (EReference)bufferMemoryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getIBufferObject()
	{
		return iBufferObjectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getIBufferObject_Usages() {
		return (EAttribute)iBufferObjectEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getStaticBuffer()
	{
		return staticBufferEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getStaticBuffer_Size()
	{
		return (EAttribute)staticBufferEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getStaticBuffer_InitWithZero()
	{
		return (EAttribute)staticBufferEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDataBuffer()
	{
		return dataBufferEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDataBuffer_Data()
	{
		return (EAttribute)dataBufferEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getBufferViewer()
	{
		return bufferViewerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getBufferViewer_DataProvider()
	{
		return (EReference)bufferViewerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getBufferViewer_GrowFactor()
	{
		return (EAttribute)bufferViewerEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getBufferViewer_GrowThreshold()
	{
		return (EAttribute)bufferViewerEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getBufferViewer_Size()
	{
		return (EAttribute)bufferViewerEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getEContextIndex()
	{
		return eContextIndexEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getEFlushMode()
	{
		return eFlushModeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EDataType getByteBuffer()
	{
		return byteBufferEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public VulkanResourceFactory getVulkanResourceFactory()
	{
		return (VulkanResourceFactory)getEFactoryInstance();
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
		transferBufferEClass = createEClass(TRANSFER_BUFFER);
		createEAttribute(transferBufferEClass, TRANSFER_BUFFER__SIZE);
		createEAttribute(transferBufferEClass, TRANSFER_BUFFER__USED_TO_PUSH);
		createEAttribute(transferBufferEClass, TRANSFER_BUFFER__USED_TO_FETCH);

		descriptorPoolEClass = createEClass(DESCRIPTOR_POOL);
		createEReference(descriptorPoolEClass, DESCRIPTOR_POOL__DESCRIPTOR_SETS);

		constantBufferEClass = createEClass(CONSTANT_BUFFER);
		createEAttribute(constantBufferEClass, CONSTANT_BUFFER__DATA);

		genericConstantBufferEClass = createEClass(GENERIC_CONSTANT_BUFFER);
		createEReference(genericConstantBufferEClass, GENERIC_CONSTANT_BUFFER__REFERENCED_VARIABLES);
		createEReference(genericConstantBufferEClass, GENERIC_CONSTANT_BUFFER__VARIABLE_PKG);

		iBufferEClass = createEClass(IBUFFER);

		bufferReferenceEClass = createEClass(BUFFER_REFERENCE);
		createEReference(bufferReferenceEClass, BUFFER_REFERENCE__BUFFERS);
		createEAttribute(bufferReferenceEClass, BUFFER_REFERENCE__STRIDE);
		createEAttribute(bufferReferenceEClass, BUFFER_REFERENCE__INDEX_TYPE);

		bufferDataProviderEClass = createEClass(BUFFER_DATA_PROVIDER);

		imageDataProviderEClass = createEClass(IMAGE_DATA_PROVIDER);

		fileImageDataProviderEClass = createEClass(FILE_IMAGE_DATA_PROVIDER);
		createEReference(fileImageDataProviderEClass, FILE_IMAGE_DATA_PROVIDER__FILE_IMAGE);

		imageEClass = createEClass(IMAGE);

		compositeImageEClass = createEClass(COMPOSITE_IMAGE);
		createEReference(compositeImageEClass, COMPOSITE_IMAGE__INLAYS);
		createEReference(compositeImageEClass, COMPOSITE_IMAGE__BACKGROUND);

		imageInlayEClass = createEClass(IMAGE_INLAY);
		createEReference(imageInlayEClass, IMAGE_INLAY__IMAGE);
		createEAttribute(imageInlayEClass, IMAGE_INLAY__POSITION);
		createEAttribute(imageInlayEClass, IMAGE_INLAY__SIZE);
		createEAttribute(imageInlayEClass, IMAGE_INLAY__HORIZONTAL_RELATIVE);
		createEAttribute(imageInlayEClass, IMAGE_INLAY__VERTICAL_RELATIVE);

		samplerEClass = createEClass(SAMPLER);
		createEReference(samplerEClass, SAMPLER__IMAGE);

		bufferDescriptorEClass = createEClass(BUFFER_DESCRIPTOR);
		createEReference(bufferDescriptorEClass, BUFFER_DESCRIPTOR__BUFFER);

		imageDescriptorEClass = createEClass(IMAGE_DESCRIPTOR);
		createEReference(imageDescriptorEClass, IMAGE_DESCRIPTOR__IMAGE);
		createEReference(imageDescriptorEClass, IMAGE_DESCRIPTOR__SAMPLER);
		createEAttribute(imageDescriptorEClass, IMAGE_DESCRIPTOR__LAYOUT);

		samplerDescriptorEClass = createEClass(SAMPLER_DESCRIPTOR);
		createEReference(samplerDescriptorEClass, SAMPLER_DESCRIPTOR__SAMPLER);

		descriptorSetEClass = createEClass(DESCRIPTOR_SET);
		createEReference(descriptorSetEClass, DESCRIPTOR_SET__DESCRIPTORS);

		bufferBarrierEClass = createEClass(BUFFER_BARRIER);
		createEReference(bufferBarrierEClass, BUFFER_BARRIER__BUFFERS);

		imageBarrierEClass = createEClass(IMAGE_BARRIER);
		createEReference(imageBarrierEClass, IMAGE_BARRIER__IMAGE);

		shaderEClass = createEClass(SHADER);
		createEReference(shaderEClass, SHADER__FILE);
		createEAttribute(shaderEClass, SHADER__STAGE);
		createEReference(shaderEClass, SHADER__CONSTANTS);

		imageArrayDescriptorEClass = createEClass(IMAGE_ARRAY_DESCRIPTOR);
		createEReference(imageArrayDescriptorEClass, IMAGE_ARRAY_DESCRIPTOR__IMAGES);
		createEAttribute(imageArrayDescriptorEClass, IMAGE_ARRAY_DESCRIPTOR__INITIAL_LAYOUT);

		memoryChunkEClass = createEClass(MEMORY_CHUNK);
		createEReference(memoryChunkEClass, MEMORY_CHUNK__PARTS);
		createEReference(memoryChunkEClass, MEMORY_CHUNK__TRANSFER_BUFFER);

		iMemoryChunkPartEClass = createEClass(IMEMORY_CHUNK_PART);

		bufferMemoryEClass = createEClass(BUFFER_MEMORY);
		createEReference(bufferMemoryEClass, BUFFER_MEMORY__BUFFERS);

		iBufferObjectEClass = createEClass(IBUFFER_OBJECT);
		createEAttribute(iBufferObjectEClass, IBUFFER_OBJECT__USAGES);

		staticBufferEClass = createEClass(STATIC_BUFFER);
		createEAttribute(staticBufferEClass, STATIC_BUFFER__SIZE);
		createEAttribute(staticBufferEClass, STATIC_BUFFER__INIT_WITH_ZERO);

		dataBufferEClass = createEClass(DATA_BUFFER);
		createEAttribute(dataBufferEClass, DATA_BUFFER__DATA);

		bufferViewerEClass = createEClass(BUFFER_VIEWER);
		createEReference(bufferViewerEClass, BUFFER_VIEWER__DATA_PROVIDER);
		createEAttribute(bufferViewerEClass, BUFFER_VIEWER__GROW_FACTOR);
		createEAttribute(bufferViewerEClass, BUFFER_VIEWER__GROW_THRESHOLD);
		createEAttribute(bufferViewerEClass, BUFFER_VIEWER__SIZE);

		staticImageEClass = createEClass(STATIC_IMAGE);
		createEAttribute(staticImageEClass, STATIC_IMAGE__FILL_WITH_ZERO);
		createEAttribute(staticImageEClass, STATIC_IMAGE__FILL_WITH);
		createEAttribute(staticImageEClass, STATIC_IMAGE__SIZE);

		imageViewerEClass = createEClass(IMAGE_VIEWER);
		createEReference(imageViewerEClass, IMAGE_VIEWER__DATA_PROVIDER);
		createEAttribute(imageViewerEClass, IMAGE_VIEWER__MIPMAP_ENABLED);

		// Create enums
		eContextIndexEEnum = createEEnum(ECONTEXT_INDEX);
		eFlushModeEEnum = createEEnum(EFLUSH_MODE);

		// Create data types
		byteBufferEDataType = createEDataType(BYTE_BUFFER);
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
		ResourcePackage theResourcePackage = (ResourcePackage)EPackage.Registry.INSTANCE.getEPackage(ResourcePackage.eNS_URI);
		VariablePackage theVariablePackage = (VariablePackage)EPackage.Registry.INSTANCE.getEPackage(VariablePackage.eNS_URI);
		TypesPackage theTypesPackage = (TypesPackage)EPackage.Registry.INSTANCE.getEPackage(TypesPackage.eNS_URI);
		ImagePackage theImagePackage = (ImagePackage)EPackage.Registry.INSTANCE.getEPackage(ImagePackage.eNS_URI);
		VulkanPackage theVulkanPackage = (VulkanPackage)EPackage.Registry.INSTANCE.getEPackage(VulkanPackage.eNS_URI);
		EnumerationPackage theEnumerationPackage = (EnumerationPackage)EPackage.Registry.INSTANCE.getEPackage(EnumerationPackage.eNS_URI);
		BarrierPackage theBarrierPackage = (BarrierPackage)EPackage.Registry.INSTANCE.getEPackage(BarrierPackage.eNS_URI);
		PipelinePackage thePipelinePackage = (PipelinePackage)EPackage.Registry.INSTANCE.getEPackage(PipelinePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		transferBufferEClass.getESuperTypes().add(theResourcePackage.getIResource());
		constantBufferEClass.getESuperTypes().add(theResourcePackage.getIResource());
		genericConstantBufferEClass.getESuperTypes().add(this.getConstantBuffer());
		iBufferEClass.getESuperTypes().add(theTypesPackage.getLNamedElement());
		bufferDataProviderEClass.getESuperTypes().add(theTypesPackage.getLNamedElement());
		imageDataProviderEClass.getESuperTypes().add(theTypesPackage.getLNamedElement());
		fileImageDataProviderEClass.getESuperTypes().add(this.getImageDataProvider());
		imageEClass.getESuperTypes().add(theImagePackage.getImageInfo());
		imageEClass.getESuperTypes().add(theResourcePackage.getIImage());
		compositeImageEClass.getESuperTypes().add(this.getImage());
		samplerEClass.getESuperTypes().add(theImagePackage.getSamplerInfo());
		samplerEClass.getESuperTypes().add(theResourcePackage.getIResource());
		bufferDescriptorEClass.getESuperTypes().add(theVulkanPackage.getIDescriptor());
		imageDescriptorEClass.getESuperTypes().add(theVulkanPackage.getIDescriptor());
		samplerDescriptorEClass.getESuperTypes().add(theVulkanPackage.getIDescriptor());
		descriptorSetEClass.getESuperTypes().add(theTypesPackage.getLNamedElement());
		bufferBarrierEClass.getESuperTypes().add(theBarrierPackage.getAbstractBufferBarrier());
		imageBarrierEClass.getESuperTypes().add(theBarrierPackage.getAbstractImageBarrier());
		shaderEClass.getESuperTypes().add(theResourcePackage.getIResource());
		imageArrayDescriptorEClass.getESuperTypes().add(theVulkanPackage.getIDescriptor());
		memoryChunkEClass.getESuperTypes().add(theResourcePackage.getIResource());
		bufferMemoryEClass.getESuperTypes().add(this.getIMemoryChunkPart());
		bufferMemoryEClass.getESuperTypes().add(theTypesPackage.getLNamedElement());
		iBufferObjectEClass.getESuperTypes().add(this.getIBuffer());
		staticBufferEClass.getESuperTypes().add(this.getIBufferObject());
		dataBufferEClass.getESuperTypes().add(this.getIBufferObject());
		bufferViewerEClass.getESuperTypes().add(this.getIBufferObject());
		staticImageEClass.getESuperTypes().add(this.getIMemoryChunkPart());
		staticImageEClass.getESuperTypes().add(this.getImage());
		imageViewerEClass.getESuperTypes().add(this.getIMemoryChunkPart());
		imageViewerEClass.getESuperTypes().add(this.getImage());

		// Initialize classes, features, and operations; add parameters
		initEClass(transferBufferEClass, TransferBuffer.class, "TransferBuffer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTransferBuffer_Size(), ecorePackage.getELong(), "size", null, 0, 1, TransferBuffer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTransferBuffer_UsedToPush(), ecorePackage.getEBoolean(), "usedToPush", "true", 1, 1, TransferBuffer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTransferBuffer_UsedToFetch(), ecorePackage.getEBoolean(), "usedToFetch", "false", 1, 1, TransferBuffer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(descriptorPoolEClass, DescriptorPool.class, "DescriptorPool", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDescriptorPool_DescriptorSets(), this.getDescriptorSet(), null, "descriptorSets", null, 0, -1, DescriptorPool.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(constantBufferEClass, ConstantBuffer.class, "ConstantBuffer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getConstantBuffer_Data(), this.getByteBuffer(), "data", null, 0, 1, ConstantBuffer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(genericConstantBufferEClass, GenericConstantBuffer.class, "GenericConstantBuffer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getGenericConstantBuffer_ReferencedVariables(), theVariablePackage.getIModelVariable(), null, "referencedVariables", null, 0, -1, GenericConstantBuffer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getGenericConstantBuffer_VariablePkg(), theVariablePackage.getModelVariablePkg(), null, "VariablePkg", null, 0, 1, GenericConstantBuffer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(iBufferEClass, IBuffer.class, "IBuffer", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(bufferReferenceEClass, BufferReference.class, "BufferReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBufferReference_Buffers(), this.getIBuffer(), null, "buffers", null, 0, -1, BufferReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBufferReference_Stride(), ecorePackage.getEInt(), "stride", "0", 0, 1, BufferReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBufferReference_IndexType(), this.getEContextIndex(), "indexType", null, 1, 1, BufferReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(bufferDataProviderEClass, BufferDataProvider.class, "BufferDataProvider", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(imageDataProviderEClass, ImageDataProvider.class, "ImageDataProvider", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(fileImageDataProviderEClass, FileImageDataProvider.class, "FileImageDataProvider", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFileImageDataProvider_FileImage(), theResourcePackage.getFileImage(), null, "fileImage", null, 1, 1, FileImageDataProvider.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(imageEClass, Image.class, "Image", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(compositeImageEClass, CompositeImage.class, "CompositeImage", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCompositeImage_Inlays(), this.getImageInlay(), null, "inlays", null, 0, -1, CompositeImage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCompositeImage_Background(), this.getImage(), null, "background", null, 1, 1, CompositeImage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(imageInlayEClass, ImageInlay.class, "ImageInlay", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getImageInlay_Image(), this.getImage(), null, "image", null, 1, 1, ImageInlay.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getImageInlay_Position(), theTypesPackage.getVector2i(), "position", "0;0", 1, 1, ImageInlay.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getImageInlay_Size(), ecorePackage.getEFloat(), "size", "1.0", 1, 1, ImageInlay.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getImageInlay_HorizontalRelative(), theTypesPackage.getEHorizontalRelative(), "horizontalRelative", "LEFT", 1, 1, ImageInlay.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getImageInlay_VerticalRelative(), theTypesPackage.getEVerticalRelative(), "verticalRelative", "TOP", 1, 1, ImageInlay.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(samplerEClass, Sampler.class, "Sampler", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSampler_Image(), this.getImage(), null, "image", null, 0, 1, Sampler.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(bufferDescriptorEClass, BufferDescriptor.class, "BufferDescriptor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBufferDescriptor_Buffer(), this.getIBuffer(), null, "buffer", null, 1, 1, BufferDescriptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(imageDescriptorEClass, ImageDescriptor.class, "ImageDescriptor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getImageDescriptor_Image(), this.getImage(), null, "image", null, 1, 1, ImageDescriptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getImageDescriptor_Sampler(), this.getSampler(), null, "sampler", null, 0, 1, ImageDescriptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getImageDescriptor_Layout(), theEnumerationPackage.getEImageLayout(), "layout", "GENERAL", 1, 1, ImageDescriptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(samplerDescriptorEClass, SamplerDescriptor.class, "SamplerDescriptor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSamplerDescriptor_Sampler(), this.getSampler(), null, "sampler", null, 1, 1, SamplerDescriptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(descriptorSetEClass, DescriptorSet.class, "DescriptorSet", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDescriptorSet_Descriptors(), theVulkanPackage.getIDescriptor(), null, "descriptors", null, 1, -1, DescriptorSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(bufferBarrierEClass, BufferBarrier.class, "BufferBarrier", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBufferBarrier_Buffers(), this.getBufferReference(), null, "buffers", null, 1, 1, BufferBarrier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(imageBarrierEClass, ImageBarrier.class, "ImageBarrier", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getImageBarrier_Image(), theResourcePackage.getIImage(), null, "image", null, 1, 1, ImageBarrier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(shaderEClass, Shader.class, "Shader", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getShader_File(), theResourcePackage.getFileResource(), null, "file", null, 0, 1, Shader.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getShader_Stage(), theEnumerationPackage.getEShaderStage(), "stage", null, 0, 1, Shader.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getShader_Constants(), thePipelinePackage.getSpecializationConstant(), null, "constants", null, 0, -1, Shader.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(imageArrayDescriptorEClass, ImageArrayDescriptor.class, "ImageArrayDescriptor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getImageArrayDescriptor_Images(), theResourcePackage.getIImage(), null, "images", null, 0, -1, ImageArrayDescriptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getImageArrayDescriptor_InitialLayout(), theEnumerationPackage.getEImageLayout(), "initialLayout", null, 1, 1, ImageArrayDescriptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(memoryChunkEClass, MemoryChunk.class, "MemoryChunk", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMemoryChunk_Parts(), this.getIMemoryChunkPart(), null, "parts", null, 0, -1, MemoryChunk.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMemoryChunk_TransferBuffer(), this.getTransferBuffer(), null, "transferBuffer", null, 0, 1, MemoryChunk.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(iMemoryChunkPartEClass, IMemoryChunkPart.class, "IMemoryChunkPart", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(bufferMemoryEClass, BufferMemory.class, "BufferMemory", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBufferMemory_Buffers(), this.getIBufferObject(), null, "buffers", null, 0, -1, BufferMemory.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(iBufferObjectEClass, IBufferObject.class, "IBufferObject", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIBufferObject_Usages(), theEnumerationPackage.getEBufferUsage(), "usages", null, 0, -1, IBufferObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(staticBufferEClass, StaticBuffer.class, "StaticBuffer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getStaticBuffer_Size(), ecorePackage.getELong(), "size", null, 0, 1, StaticBuffer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getStaticBuffer_InitWithZero(), ecorePackage.getEBoolean(), "initWithZero", "false", 0, 1, StaticBuffer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dataBufferEClass, DataBuffer.class, "DataBuffer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDataBuffer_Data(), this.getByteBuffer(), "data", null, 0, 1, DataBuffer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(bufferViewerEClass, BufferViewer.class, "BufferViewer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBufferViewer_DataProvider(), this.getBufferDataProvider(), null, "dataProvider", null, 1, 1, BufferViewer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBufferViewer_GrowFactor(), ecorePackage.getEFloat(), "growFactor", "1", 1, 1, BufferViewer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBufferViewer_GrowThreshold(), ecorePackage.getEFloat(), "growThreshold", "1", 1, 1, BufferViewer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBufferViewer_Size(), ecorePackage.getELong(), "size", "0", 0, 1, BufferViewer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(staticImageEClass, StaticImage.class, "StaticImage", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getStaticImage_FillWithZero(), ecorePackage.getEBoolean(), "fillWithZero", "false", 0, 1, StaticImage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getStaticImage_FillWith(), this.getByteBuffer(), "fillWith", null, 0, 1, StaticImage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getStaticImage_Size(), theTypesPackage.getVector2i(), "size", "1;1", 1, 1, StaticImage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(imageViewerEClass, ImageViewer.class, "ImageViewer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getImageViewer_DataProvider(), this.getImageDataProvider(), null, "dataProvider", null, 1, 1, ImageViewer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getImageViewer_MipmapEnabled(), ecorePackage.getEBoolean(), "mipmapEnabled", "false", 1, 1, ImageViewer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(eContextIndexEEnum, EContextIndex.class, "EContextIndex");
		addEEnumLiteral(eContextIndexEEnum, EContextIndex.CONTEXT_INSTANCE);
		addEEnumLiteral(eContextIndexEEnum, EContextIndex.CONTEXT_INSTANCE_PLUS_ONE);
		addEEnumLiteral(eContextIndexEEnum, EContextIndex.CONTEXT_INSTANCE_MINUS_ONE);

		initEEnum(eFlushModeEEnum, EFlushMode.class, "EFlushMode");
		addEEnumLiteral(eFlushModeEEnum, EFlushMode.PUSH);
		addEEnumLiteral(eFlushModeEEnum, EFlushMode.FETCH);

		// Initialize data types
		initEDataType(byteBufferEDataType, ByteBuffer.class, "ByteBuffer", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //VulkanResourcePackageImpl
