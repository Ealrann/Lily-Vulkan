/**
 */
package org.sheepy.lily.vulkan.model.resource.impl;

import java.nio.ByteBuffer;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.ETypeParameter;
import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.sheepy.lily.core.model.action.ActionPackage;

import org.sheepy.lily.core.model.application.ApplicationPackage;

import org.sheepy.lily.core.model.cadence.CadencePackage;
import org.sheepy.lily.core.model.inference.InferencePackage;
import org.sheepy.lily.core.model.maintainer.MaintainerPackage;
import org.sheepy.lily.core.model.types.TypesPackage;

import org.sheepy.lily.vulkan.model.VulkanPackage;
import org.sheepy.lily.vulkan.model.binding.BindingPackage;
import org.sheepy.lily.vulkan.model.binding.impl.BindingPackageImpl;
import org.sheepy.lily.vulkan.model.impl.VulkanPackageImpl;
import org.sheepy.lily.vulkan.model.process.ProcessPackage;
import org.sheepy.lily.vulkan.model.process.compute.ComputePackage;
import org.sheepy.lily.vulkan.model.process.compute.impl.ComputePackageImpl;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage;
import org.sheepy.lily.vulkan.model.process.graphic.impl.GraphicPackageImpl;
import org.sheepy.lily.vulkan.model.process.impl.ProcessPackageImpl;
import org.sheepy.lily.vulkan.model.resource.Buffer;
import org.sheepy.lily.vulkan.model.resource.BufferBarrier;
import org.sheepy.lily.vulkan.model.resource.BufferDataProvider;
import org.sheepy.lily.vulkan.model.resource.BufferDescriptor;
import org.sheepy.lily.vulkan.model.resource.BufferReference;
import org.sheepy.lily.vulkan.model.resource.CompositeBuffer;
import org.sheepy.lily.vulkan.model.resource.CompositeBufferBarrier;
import org.sheepy.lily.vulkan.model.resource.CompositeBufferReference;
import org.sheepy.lily.vulkan.model.resource.CompositePartReference;
import org.sheepy.lily.vulkan.model.resource.ConstantBuffer;
import org.sheepy.lily.vulkan.model.resource.DescriptorSet;
import org.sheepy.lily.vulkan.model.resource.DescriptorSetPkg;
import org.sheepy.lily.vulkan.model.resource.EFlushMode;
import org.sheepy.lily.vulkan.model.resource.FileImage;
import org.sheepy.lily.vulkan.model.resource.FontImage;
import org.sheepy.lily.vulkan.model.resource.IBuffer;
import org.sheepy.lily.vulkan.model.resource.IBufferReference;
import org.sheepy.lily.vulkan.model.resource.Image;
import org.sheepy.lily.vulkan.model.resource.ImageBarrier;
import org.sheepy.lily.vulkan.model.resource.ImageDescriptor;
import org.sheepy.lily.vulkan.model.resource.ResourceFactory;
import org.sheepy.lily.vulkan.model.resource.ResourcePackage;
import org.sheepy.lily.vulkan.model.resource.SampledImage;
import org.sheepy.lily.vulkan.model.resource.SampledImageDescriptor;
import org.sheepy.lily.vulkan.model.resource.Sampler;
import org.sheepy.lily.vulkan.model.resource.SamplerDescriptor;
import org.sheepy.lily.vulkan.model.resource.Semaphore;
import org.sheepy.lily.vulkan.model.resource.Shader;
import org.sheepy.lily.vulkan.model.resource.StaticImage;
import org.sheepy.lily.vulkan.model.resource.Texture2DArray;
import org.sheepy.lily.vulkan.model.resource.Texture2DArrayDescriptor;
import org.sheepy.lily.vulkan.model.resource.TransferBuffer;
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
public class ResourcePackageImpl extends EPackageImpl implements ResourcePackage
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
	private EClass constantBufferEClass = null;

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
	private EClass bufferEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass compositeBufferEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass compositePartReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iBufferReferenceEClass = null;

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
	private EClass compositeBufferReferenceEClass = null;

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
	private EClass fileImageEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sampledImageEClass = null;

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
	private EClass semaphoreEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass fontImageEClass = null;

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
	private EClass sampledImageDescriptorEClass = null;

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
	private EClass texture2DArrayDescriptorEClass = null;

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
	private EClass descriptorSetPkgEClass = null;

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
	private EClass compositeBufferBarrierEClass = null;

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
	private EClass texture2DArrayEClass = null;

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
	 * @see org.sheepy.lily.vulkan.model.resource.ResourcePackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ResourcePackageImpl()
	{
		super(eNS_URI, ResourceFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link ResourcePackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ResourcePackage init()
	{
		if (isInited) return (ResourcePackage)EPackage.Registry.INSTANCE.getEPackage(ResourcePackage.eNS_URI);

		// Obtain or create and register package
		Object registeredResourcePackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		ResourcePackageImpl theResourcePackage = registeredResourcePackage instanceof ResourcePackageImpl ? (ResourcePackageImpl)registeredResourcePackage : new ResourcePackageImpl();

		isInited = true;

		// Initialize simple dependencies
		ApplicationPackage.eINSTANCE.eClass();
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

		// Obtain or create and register interdependencies
		Object registeredPackage = EPackage.Registry.INSTANCE.getEPackage(BindingPackage.eNS_URI);
		BindingPackageImpl theBindingPackage = (BindingPackageImpl)(registeredPackage instanceof BindingPackageImpl ? registeredPackage : BindingPackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(ComputePackage.eNS_URI);
		ComputePackageImpl theComputePackage = (ComputePackageImpl)(registeredPackage instanceof ComputePackageImpl ? registeredPackage : ComputePackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(GraphicPackage.eNS_URI);
		GraphicPackageImpl theGraphicPackage = (GraphicPackageImpl)(registeredPackage instanceof GraphicPackageImpl ? registeredPackage : GraphicPackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(ProcessPackage.eNS_URI);
		ProcessPackageImpl theProcessPackage = (ProcessPackageImpl)(registeredPackage instanceof ProcessPackageImpl ? registeredPackage : ProcessPackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(VulkanPackage.eNS_URI);
		VulkanPackageImpl theVulkanPackage = (VulkanPackageImpl)(registeredPackage instanceof VulkanPackageImpl ? registeredPackage : VulkanPackage.eINSTANCE);

		// Create package meta-data objects
		theResourcePackage.createPackageContents();
		theBindingPackage.createPackageContents();
		theComputePackage.createPackageContents();
		theGraphicPackage.createPackageContents();
		theProcessPackage.createPackageContents();
		theVulkanPackage.createPackageContents();

		// Initialize created meta-data
		theResourcePackage.initializePackageContents();
		theBindingPackage.initializePackageContents();
		theComputePackage.initializePackageContents();
		theGraphicPackage.initializePackageContents();
		theProcessPackage.initializePackageContents();
		theVulkanPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theResourcePackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ResourcePackage.eNS_URI, theResourcePackage);
		return theResourcePackage;
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
	public EAttribute getTransferBuffer_InstanceCount()
	{
		return (EAttribute)transferBufferEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTransferBuffer_UsedToPush()
	{
		return (EAttribute)transferBufferEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTransferBuffer_UsedToFetch()
	{
		return (EAttribute)transferBufferEClass.getEStructuralFeatures().get(3);
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
	public EClass getBuffer()
	{
		return bufferEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getBuffer_Size()
	{
		return (EAttribute)bufferEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getBuffer_Usages()
	{
		return (EAttribute)bufferEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getBuffer_Data()
	{
		return (EAttribute)bufferEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getBuffer_KeptMapped()
	{
		return (EAttribute)bufferEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getBuffer_HostVisible()
	{
		return (EAttribute)bufferEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getBuffer_InstanceCount()
	{
		return (EAttribute)bufferEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getBuffer_Coherent()
	{
		return (EAttribute)bufferEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getCompositeBuffer()
	{
		return compositeBufferEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCompositeBuffer_DataProviders()
	{
		return (EReference)compositeBufferEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCompositeBuffer_TransferBuffer()
	{
		return (EReference)compositeBufferEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getCompositeBuffer_MinSize()
	{
		return (EAttribute)compositeBufferEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getCompositePartReference()
	{
		return compositePartReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getCompositePartReference_Part()
	{
		return (EAttribute)compositePartReferenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getCompositePartReference_Instance()
	{
		return (EAttribute)compositePartReferenceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getIBufferReference()
	{
		return iBufferReferenceEClass;
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
	public EReference getBufferReference_Buffer()
	{
		return (EReference)bufferReferenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getBufferReference_Offset()
	{
		return (EAttribute)bufferReferenceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getCompositeBufferReference()
	{
		return compositeBufferReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCompositeBufferReference_Buffer()
	{
		return (EReference)compositeBufferReferenceEClass.getEStructuralFeatures().get(0);
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
	public EAttribute getBufferDataProvider_Usage()
	{
		return (EAttribute)bufferDataProviderEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getBufferDataProvider_InstanceCount()
	{
		return (EAttribute)bufferDataProviderEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getBufferDataProvider_DataSource()
	{
		return (EReference)bufferDataProviderEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getBufferDataProvider_UsedToPush()
	{
		return (EAttribute)bufferDataProviderEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getBufferDataProvider_UsedToFetch()
	{
		return (EAttribute)bufferDataProviderEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getBufferDataProvider_StageBeforePush()
	{
		return (EAttribute)bufferDataProviderEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getBufferDataProvider_AccessBeforePush()
	{
		return (EAttribute)bufferDataProviderEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getBufferDataProvider_StageBeforeFetch()
	{
		return (EAttribute)bufferDataProviderEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getBufferDataProvider_AccessBeforeFetch()
	{
		return (EAttribute)bufferDataProviderEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getBufferDataProvider_GrowFactor()
	{
		return (EAttribute)bufferDataProviderEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getBufferDataProvider_GrowThreshold()
	{
		return (EAttribute)bufferDataProviderEClass.getEStructuralFeatures().get(10);
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
	public EReference getImage_InitialLayout()
	{
		return (EReference)imageEClass.getEStructuralFeatures().get(0);
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
	public EClass getFileImage()
	{
		return fileImageEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getFileImage_File()
	{
		return (EReference)fileImageEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getFileImage_MipmapEnabled()
	{
		return (EAttribute)fileImageEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getSampledImage()
	{
		return sampledImageEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getSampledImage_Sampler()
	{
		return (EReference)sampledImageEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getSampledImage_Image()
	{
		return (EReference)sampledImageEClass.getEStructuralFeatures().get(1);
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
	public EClass getSemaphore()
	{
		return semaphoreEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSemaphore_SignalizedAtInit()
	{
		return (EAttribute)semaphoreEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSemaphore_WaitStage()
	{
		return (EAttribute)semaphoreEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getFontImage()
	{
		return fontImageEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getFontImage_File()
	{
		return (EReference)fontImageEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getFontImage_Height()
	{
		return (EAttribute)fontImageEClass.getEStructuralFeatures().get(1);
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
	public EReference getBufferDescriptor_BufferReference()
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
	public EClass getSampledImageDescriptor()
	{
		return sampledImageDescriptorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getSampledImageDescriptor_SampledImage()
	{
		return (EReference)sampledImageDescriptorEClass.getEStructuralFeatures().get(0);
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
	public EClass getTexture2DArrayDescriptor()
	{
		return texture2DArrayDescriptorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTexture2DArrayDescriptor_Texture2DArray()
	{
		return (EReference)texture2DArrayDescriptorEClass.getEStructuralFeatures().get(0);
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
	public EClass getDescriptorSetPkg()
	{
		return descriptorSetPkgEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDescriptorSetPkg_DescriptorSets()
	{
		return (EReference)descriptorSetPkgEClass.getEStructuralFeatures().get(0);
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
	public EReference getBufferBarrier_Buffer()
	{
		return (EReference)bufferBarrierEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getCompositeBufferBarrier()
	{
		return compositeBufferBarrierEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getCompositeBufferBarrier_Instance()
	{
		return (EAttribute)compositeBufferBarrierEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCompositeBufferBarrier_DataProvider()
	{
		return (EReference)compositeBufferBarrierEClass.getEStructuralFeatures().get(1);
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
	public EClass getTexture2DArray()
	{
		return texture2DArrayEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTexture2DArray_Files()
	{
		return (EReference)texture2DArrayEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTexture2DArray_MipmapEnabled()
	{
		return (EAttribute)texture2DArrayEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTexture2DArray_InitialLayout()
	{
		return (EReference)texture2DArrayEClass.getEStructuralFeatures().get(2);
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
	public ResourceFactory getResourceFactory()
	{
		return (ResourceFactory)getEFactoryInstance();
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
		createEAttribute(transferBufferEClass, TRANSFER_BUFFER__INSTANCE_COUNT);
		createEAttribute(transferBufferEClass, TRANSFER_BUFFER__USED_TO_PUSH);
		createEAttribute(transferBufferEClass, TRANSFER_BUFFER__USED_TO_FETCH);

		constantBufferEClass = createEClass(CONSTANT_BUFFER);
		createEAttribute(constantBufferEClass, CONSTANT_BUFFER__DATA);

		iBufferEClass = createEClass(IBUFFER);

		bufferEClass = createEClass(BUFFER);
		createEAttribute(bufferEClass, BUFFER__SIZE);
		createEAttribute(bufferEClass, BUFFER__USAGES);
		createEAttribute(bufferEClass, BUFFER__DATA);
		createEAttribute(bufferEClass, BUFFER__KEPT_MAPPED);
		createEAttribute(bufferEClass, BUFFER__HOST_VISIBLE);
		createEAttribute(bufferEClass, BUFFER__INSTANCE_COUNT);
		createEAttribute(bufferEClass, BUFFER__COHERENT);

		compositeBufferEClass = createEClass(COMPOSITE_BUFFER);
		createEReference(compositeBufferEClass, COMPOSITE_BUFFER__DATA_PROVIDERS);
		createEReference(compositeBufferEClass, COMPOSITE_BUFFER__TRANSFER_BUFFER);
		createEAttribute(compositeBufferEClass, COMPOSITE_BUFFER__MIN_SIZE);

		compositePartReferenceEClass = createEClass(COMPOSITE_PART_REFERENCE);
		createEAttribute(compositePartReferenceEClass, COMPOSITE_PART_REFERENCE__PART);
		createEAttribute(compositePartReferenceEClass, COMPOSITE_PART_REFERENCE__INSTANCE);

		iBufferReferenceEClass = createEClass(IBUFFER_REFERENCE);

		bufferReferenceEClass = createEClass(BUFFER_REFERENCE);
		createEReference(bufferReferenceEClass, BUFFER_REFERENCE__BUFFER);
		createEAttribute(bufferReferenceEClass, BUFFER_REFERENCE__OFFSET);

		compositeBufferReferenceEClass = createEClass(COMPOSITE_BUFFER_REFERENCE);
		createEReference(compositeBufferReferenceEClass, COMPOSITE_BUFFER_REFERENCE__BUFFER);

		bufferDataProviderEClass = createEClass(BUFFER_DATA_PROVIDER);
		createEAttribute(bufferDataProviderEClass, BUFFER_DATA_PROVIDER__USAGE);
		createEAttribute(bufferDataProviderEClass, BUFFER_DATA_PROVIDER__INSTANCE_COUNT);
		createEReference(bufferDataProviderEClass, BUFFER_DATA_PROVIDER__DATA_SOURCE);
		createEAttribute(bufferDataProviderEClass, BUFFER_DATA_PROVIDER__USED_TO_PUSH);
		createEAttribute(bufferDataProviderEClass, BUFFER_DATA_PROVIDER__USED_TO_FETCH);
		createEAttribute(bufferDataProviderEClass, BUFFER_DATA_PROVIDER__STAGE_BEFORE_PUSH);
		createEAttribute(bufferDataProviderEClass, BUFFER_DATA_PROVIDER__ACCESS_BEFORE_PUSH);
		createEAttribute(bufferDataProviderEClass, BUFFER_DATA_PROVIDER__STAGE_BEFORE_FETCH);
		createEAttribute(bufferDataProviderEClass, BUFFER_DATA_PROVIDER__ACCESS_BEFORE_FETCH);
		createEAttribute(bufferDataProviderEClass, BUFFER_DATA_PROVIDER__GROW_FACTOR);
		createEAttribute(bufferDataProviderEClass, BUFFER_DATA_PROVIDER__GROW_THRESHOLD);

		imageEClass = createEClass(IMAGE);
		createEReference(imageEClass, IMAGE__INITIAL_LAYOUT);

		staticImageEClass = createEClass(STATIC_IMAGE);
		createEAttribute(staticImageEClass, STATIC_IMAGE__FILL_WITH_ZERO);
		createEAttribute(staticImageEClass, STATIC_IMAGE__FILL_WITH);

		fileImageEClass = createEClass(FILE_IMAGE);
		createEReference(fileImageEClass, FILE_IMAGE__FILE);
		createEAttribute(fileImageEClass, FILE_IMAGE__MIPMAP_ENABLED);

		sampledImageEClass = createEClass(SAMPLED_IMAGE);
		createEReference(sampledImageEClass, SAMPLED_IMAGE__SAMPLER);
		createEReference(sampledImageEClass, SAMPLED_IMAGE__IMAGE);

		samplerEClass = createEClass(SAMPLER);
		createEReference(samplerEClass, SAMPLER__IMAGE);

		semaphoreEClass = createEClass(SEMAPHORE);
		createEAttribute(semaphoreEClass, SEMAPHORE__SIGNALIZED_AT_INIT);
		createEAttribute(semaphoreEClass, SEMAPHORE__WAIT_STAGE);

		fontImageEClass = createEClass(FONT_IMAGE);
		createEReference(fontImageEClass, FONT_IMAGE__FILE);
		createEAttribute(fontImageEClass, FONT_IMAGE__HEIGHT);

		bufferDescriptorEClass = createEClass(BUFFER_DESCRIPTOR);
		createEReference(bufferDescriptorEClass, BUFFER_DESCRIPTOR__BUFFER_REFERENCE);

		imageDescriptorEClass = createEClass(IMAGE_DESCRIPTOR);
		createEReference(imageDescriptorEClass, IMAGE_DESCRIPTOR__IMAGE);

		sampledImageDescriptorEClass = createEClass(SAMPLED_IMAGE_DESCRIPTOR);
		createEReference(sampledImageDescriptorEClass, SAMPLED_IMAGE_DESCRIPTOR__SAMPLED_IMAGE);

		samplerDescriptorEClass = createEClass(SAMPLER_DESCRIPTOR);
		createEReference(samplerDescriptorEClass, SAMPLER_DESCRIPTOR__SAMPLER);

		texture2DArrayDescriptorEClass = createEClass(TEXTURE2_DARRAY_DESCRIPTOR);
		createEReference(texture2DArrayDescriptorEClass, TEXTURE2_DARRAY_DESCRIPTOR__TEXTURE2_DARRAY);

		descriptorSetEClass = createEClass(DESCRIPTOR_SET);
		createEReference(descriptorSetEClass, DESCRIPTOR_SET__DESCRIPTORS);

		descriptorSetPkgEClass = createEClass(DESCRIPTOR_SET_PKG);
		createEReference(descriptorSetPkgEClass, DESCRIPTOR_SET_PKG__DESCRIPTOR_SETS);

		bufferBarrierEClass = createEClass(BUFFER_BARRIER);
		createEReference(bufferBarrierEClass, BUFFER_BARRIER__BUFFER);

		compositeBufferBarrierEClass = createEClass(COMPOSITE_BUFFER_BARRIER);
		createEAttribute(compositeBufferBarrierEClass, COMPOSITE_BUFFER_BARRIER__INSTANCE);
		createEReference(compositeBufferBarrierEClass, COMPOSITE_BUFFER_BARRIER__DATA_PROVIDER);

		imageBarrierEClass = createEClass(IMAGE_BARRIER);
		createEReference(imageBarrierEClass, IMAGE_BARRIER__IMAGE);

		shaderEClass = createEClass(SHADER);
		createEReference(shaderEClass, SHADER__FILE);
		createEAttribute(shaderEClass, SHADER__STAGE);
		createEReference(shaderEClass, SHADER__CONSTANTS);

		texture2DArrayEClass = createEClass(TEXTURE2_DARRAY);
		createEReference(texture2DArrayEClass, TEXTURE2_DARRAY__FILES);
		createEAttribute(texture2DArrayEClass, TEXTURE2_DARRAY__MIPMAP_ENABLED);
		createEReference(texture2DArrayEClass, TEXTURE2_DARRAY__INITIAL_LAYOUT);

		// Create enums
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
		ApplicationPackage theApplicationPackage = (ApplicationPackage)EPackage.Registry.INSTANCE.getEPackage(ApplicationPackage.eNS_URI);
		EnumerationPackage theEnumerationPackage = (EnumerationPackage)EPackage.Registry.INSTANCE.getEPackage(EnumerationPackage.eNS_URI);
		TypesPackage theTypesPackage = (TypesPackage)EPackage.Registry.INSTANCE.getEPackage(TypesPackage.eNS_URI);
		ImagePackage theImagePackage = (ImagePackage)EPackage.Registry.INSTANCE.getEPackage(ImagePackage.eNS_URI);
		VulkanPackage theVulkanPackage = (VulkanPackage)EPackage.Registry.INSTANCE.getEPackage(VulkanPackage.eNS_URI);
		BarrierPackage theBarrierPackage = (BarrierPackage)EPackage.Registry.INSTANCE.getEPackage(BarrierPackage.eNS_URI);
		PipelinePackage thePipelinePackage = (PipelinePackage)EPackage.Registry.INSTANCE.getEPackage(PipelinePackage.eNS_URI);

		// Create type parameters
		ETypeParameter bufferDataProviderEClass_T = addETypeParameter(bufferDataProviderEClass, "T");

		// Set bounds for type parameters

		// Add supertypes to classes
		transferBufferEClass.getESuperTypes().add(theApplicationPackage.getIResource());
		constantBufferEClass.getESuperTypes().add(theApplicationPackage.getIResource());
		iBufferEClass.getESuperTypes().add(theApplicationPackage.getIResource());
		bufferEClass.getESuperTypes().add(this.getIBuffer());
		compositeBufferEClass.getESuperTypes().add(this.getIBuffer());
		compositePartReferenceEClass.getESuperTypes().add(theTypesPackage.getLNamedElement());
		bufferReferenceEClass.getESuperTypes().add(this.getIBufferReference());
		compositeBufferReferenceEClass.getESuperTypes().add(this.getCompositePartReference());
		compositeBufferReferenceEClass.getESuperTypes().add(this.getIBufferReference());
		bufferDataProviderEClass.getESuperTypes().add(theTypesPackage.getLNamedElement());
		imageEClass.getESuperTypes().add(theApplicationPackage.getIResource());
		staticImageEClass.getESuperTypes().add(this.getImage());
		staticImageEClass.getESuperTypes().add(theImagePackage.getImageInfo());
		fileImageEClass.getESuperTypes().add(this.getImage());
		sampledImageEClass.getESuperTypes().add(theApplicationPackage.getIResource());
		samplerEClass.getESuperTypes().add(theImagePackage.getSamplerInfo());
		samplerEClass.getESuperTypes().add(theApplicationPackage.getIResource());
		semaphoreEClass.getESuperTypes().add(theApplicationPackage.getIResource());
		fontImageEClass.getESuperTypes().add(this.getImage());
		bufferDescriptorEClass.getESuperTypes().add(theVulkanPackage.getIDescriptor());
		imageDescriptorEClass.getESuperTypes().add(theVulkanPackage.getIDescriptor());
		sampledImageDescriptorEClass.getESuperTypes().add(theVulkanPackage.getIDescriptor());
		samplerDescriptorEClass.getESuperTypes().add(theVulkanPackage.getIDescriptor());
		texture2DArrayDescriptorEClass.getESuperTypes().add(theVulkanPackage.getIDescriptor());
		descriptorSetEClass.getESuperTypes().add(theTypesPackage.getLNamedElement());
		bufferBarrierEClass.getESuperTypes().add(theBarrierPackage.getAbstractBufferBarrier());
		compositeBufferBarrierEClass.getESuperTypes().add(theBarrierPackage.getAbstractBufferBarrier());
		imageBarrierEClass.getESuperTypes().add(theBarrierPackage.getAbstractImageBarrier());
		shaderEClass.getESuperTypes().add(theApplicationPackage.getIResource());
		texture2DArrayEClass.getESuperTypes().add(theApplicationPackage.getIResource());

		// Initialize classes, features, and operations; add parameters
		initEClass(transferBufferEClass, TransferBuffer.class, "TransferBuffer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTransferBuffer_Size(), ecorePackage.getELong(), "size", null, 0, 1, TransferBuffer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTransferBuffer_InstanceCount(), ecorePackage.getEInt(), "instanceCount", "3", 0, 1, TransferBuffer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTransferBuffer_UsedToPush(), ecorePackage.getEBoolean(), "usedToPush", "true", 1, 1, TransferBuffer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTransferBuffer_UsedToFetch(), ecorePackage.getEBoolean(), "usedToFetch", "false", 1, 1, TransferBuffer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(constantBufferEClass, ConstantBuffer.class, "ConstantBuffer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getConstantBuffer_Data(), this.getByteBuffer(), "data", null, 0, 1, ConstantBuffer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(iBufferEClass, IBuffer.class, "IBuffer", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(bufferEClass, Buffer.class, "Buffer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getBuffer_Size(), ecorePackage.getELong(), "size", null, 0, 1, Buffer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBuffer_Usages(), theEnumerationPackage.getEBufferUsage(), "usages", null, 0, -1, Buffer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBuffer_Data(), this.getByteBuffer(), "data", null, 0, 1, Buffer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBuffer_KeptMapped(), ecorePackage.getEBoolean(), "keptMapped", "false", 0, 1, Buffer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBuffer_HostVisible(), ecorePackage.getEBoolean(), "hostVisible", "false", 0, 1, Buffer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBuffer_InstanceCount(), ecorePackage.getEInt(), "instanceCount", "1", 0, 1, Buffer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBuffer_Coherent(), ecorePackage.getEBoolean(), "coherent", "true", 0, 1, Buffer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(compositeBufferEClass, CompositeBuffer.class, "CompositeBuffer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		EGenericType g1 = createEGenericType(this.getBufferDataProvider());
		EGenericType g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		initEReference(getCompositeBuffer_DataProviders(), g1, null, "dataProviders", null, 0, -1, CompositeBuffer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCompositeBuffer_TransferBuffer(), this.getTransferBuffer(), null, "transferBuffer", null, 1, 1, CompositeBuffer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCompositeBuffer_MinSize(), ecorePackage.getELong(), "minSize", "0", 1, 1, CompositeBuffer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(compositePartReferenceEClass, CompositePartReference.class, "CompositePartReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCompositePartReference_Part(), ecorePackage.getEInt(), "part", null, 0, 1, CompositePartReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCompositePartReference_Instance(), ecorePackage.getEInt(), "instance", "0", 1, 1, CompositePartReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(iBufferReferenceEClass, IBufferReference.class, "IBufferReference", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(bufferReferenceEClass, BufferReference.class, "BufferReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBufferReference_Buffer(), this.getBuffer(), null, "buffer", null, 1, 1, BufferReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBufferReference_Offset(), ecorePackage.getELong(), "offset", "0", 1, 1, BufferReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(compositeBufferReferenceEClass, CompositeBufferReference.class, "CompositeBufferReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCompositeBufferReference_Buffer(), this.getCompositeBuffer(), null, "buffer", null, 1, 1, CompositeBufferReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(bufferDataProviderEClass, BufferDataProvider.class, "BufferDataProvider", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getBufferDataProvider_Usage(), theEnumerationPackage.getEBufferUsage(), "usage", null, 1, 1, BufferDataProvider.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBufferDataProvider_InstanceCount(), ecorePackage.getEInt(), "instanceCount", "1", 1, 1, BufferDataProvider.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		g1 = createEGenericType(bufferDataProviderEClass_T);
		initEReference(getBufferDataProvider_DataSource(), g1, null, "dataSource", null, 0, 1, BufferDataProvider.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBufferDataProvider_UsedToPush(), ecorePackage.getEBoolean(), "usedToPush", "true", 1, 1, BufferDataProvider.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBufferDataProvider_UsedToFetch(), ecorePackage.getEBoolean(), "usedToFetch", "false", 1, 1, BufferDataProvider.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBufferDataProvider_StageBeforePush(), theEnumerationPackage.getEPipelineStage(), "stageBeforePush", null, 0, 1, BufferDataProvider.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBufferDataProvider_AccessBeforePush(), theEnumerationPackage.getEAccess(), "accessBeforePush", null, 0, -1, BufferDataProvider.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBufferDataProvider_StageBeforeFetch(), theEnumerationPackage.getEPipelineStage(), "stageBeforeFetch", null, 0, 1, BufferDataProvider.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBufferDataProvider_AccessBeforeFetch(), theEnumerationPackage.getEAccess(), "accessBeforeFetch", null, 0, -1, BufferDataProvider.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBufferDataProvider_GrowFactor(), ecorePackage.getEFloat(), "growFactor", "1", 1, 1, BufferDataProvider.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBufferDataProvider_GrowThreshold(), ecorePackage.getEFloat(), "growThreshold", "1", 1, 1, BufferDataProvider.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(imageEClass, Image.class, "Image", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getImage_InitialLayout(), theImagePackage.getImageLayout(), null, "initialLayout", null, 0, 1, Image.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(staticImageEClass, StaticImage.class, "StaticImage", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getStaticImage_FillWithZero(), ecorePackage.getEBoolean(), "fillWithZero", "false", 0, 1, StaticImage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getStaticImage_FillWith(), this.getByteBuffer(), "fillWith", null, 0, 1, StaticImage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(fileImageEClass, FileImage.class, "FileImage", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFileImage_File(), theApplicationPackage.getFileResource(), null, "file", null, 0, 1, FileImage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFileImage_MipmapEnabled(), ecorePackage.getEBoolean(), "mipmapEnabled", "false", 0, 1, FileImage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(sampledImageEClass, SampledImage.class, "SampledImage", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSampledImage_Sampler(), theImagePackage.getSamplerInfo(), null, "sampler", null, 1, 1, SampledImage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSampledImage_Image(), this.getImage(), null, "image", null, 1, 1, SampledImage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(samplerEClass, Sampler.class, "Sampler", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSampler_Image(), this.getImage(), null, "image", null, 0, 1, Sampler.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(semaphoreEClass, Semaphore.class, "Semaphore", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSemaphore_SignalizedAtInit(), ecorePackage.getEBoolean(), "signalizedAtInit", "false", 0, 1, Semaphore.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSemaphore_WaitStage(), theEnumerationPackage.getEPipelineStage(), "waitStage", null, 0, 1, Semaphore.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(fontImageEClass, FontImage.class, "FontImage", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFontImage_File(), theApplicationPackage.getFileResource(), null, "file", null, 0, 1, FontImage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFontImage_Height(), ecorePackage.getEInt(), "height", "18", 0, 1, FontImage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(bufferDescriptorEClass, BufferDescriptor.class, "BufferDescriptor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBufferDescriptor_BufferReference(), this.getIBufferReference(), null, "bufferReference", null, 1, 1, BufferDescriptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(imageDescriptorEClass, ImageDescriptor.class, "ImageDescriptor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getImageDescriptor_Image(), this.getImage(), null, "image", null, 1, 1, ImageDescriptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(sampledImageDescriptorEClass, SampledImageDescriptor.class, "SampledImageDescriptor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSampledImageDescriptor_SampledImage(), this.getSampledImage(), null, "sampledImage", null, 0, 1, SampledImageDescriptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(samplerDescriptorEClass, SamplerDescriptor.class, "SamplerDescriptor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSamplerDescriptor_Sampler(), this.getSampler(), null, "sampler", null, 1, 1, SamplerDescriptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(texture2DArrayDescriptorEClass, Texture2DArrayDescriptor.class, "Texture2DArrayDescriptor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTexture2DArrayDescriptor_Texture2DArray(), this.getTexture2DArray(), null, "texture2DArray", null, 1, 1, Texture2DArrayDescriptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(descriptorSetEClass, DescriptorSet.class, "DescriptorSet", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDescriptorSet_Descriptors(), theVulkanPackage.getIDescriptor(), null, "descriptors", null, 1, -1, DescriptorSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(descriptorSetPkgEClass, DescriptorSetPkg.class, "DescriptorSetPkg", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDescriptorSetPkg_DescriptorSets(), this.getDescriptorSet(), null, "descriptorSets", null, 0, -1, DescriptorSetPkg.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(bufferBarrierEClass, BufferBarrier.class, "BufferBarrier", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBufferBarrier_Buffer(), this.getBuffer(), null, "buffer", null, 0, 1, BufferBarrier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(compositeBufferBarrierEClass, CompositeBufferBarrier.class, "CompositeBufferBarrier", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCompositeBufferBarrier_Instance(), ecorePackage.getEInt(), "instance", "0", 1, 1, CompositeBufferBarrier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		g1 = createEGenericType(this.getBufferDataProvider());
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		initEReference(getCompositeBufferBarrier_DataProvider(), g1, null, "dataProvider", null, 1, 1, CompositeBufferBarrier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(imageBarrierEClass, ImageBarrier.class, "ImageBarrier", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getImageBarrier_Image(), this.getImage(), null, "image", null, 1, 1, ImageBarrier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(shaderEClass, Shader.class, "Shader", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getShader_File(), theApplicationPackage.getFileResource(), null, "file", null, 0, 1, Shader.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getShader_Stage(), theEnumerationPackage.getEShaderStage(), "stage", null, 0, 1, Shader.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getShader_Constants(), thePipelinePackage.getSpecializationConstant(), null, "constants", null, 0, -1, Shader.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(texture2DArrayEClass, Texture2DArray.class, "Texture2DArray", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTexture2DArray_Files(), theApplicationPackage.getFileResource(), null, "files", null, 1, -1, Texture2DArray.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTexture2DArray_MipmapEnabled(), ecorePackage.getEBoolean(), "mipmapEnabled", "false", 0, 1, Texture2DArray.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTexture2DArray_InitialLayout(), theImagePackage.getImageLayout(), null, "initialLayout", null, 0, 1, Texture2DArray.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(eFlushModeEEnum, EFlushMode.class, "EFlushMode");
		addEEnumLiteral(eFlushModeEEnum, EFlushMode.PUSH);
		addEEnumLiteral(eFlushModeEEnum, EFlushMode.FETCH);

		// Initialize data types
		initEDataType(byteBufferEDataType, ByteBuffer.class, "ByteBuffer", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //ResourcePackageImpl
