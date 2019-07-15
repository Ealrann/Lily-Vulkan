/**
 */
package org.sheepy.lily.vulkan.model.resource.impl;

import java.nio.ByteBuffer;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.sheepy.lily.core.model.action.ActionPackage;

import org.sheepy.lily.core.model.application.ApplicationPackage;

import org.sheepy.lily.core.model.inference.InferencePackage;
import org.sheepy.lily.core.model.maintainer.MaintainerPackage;
import org.sheepy.lily.core.model.root.RootPackage;

import org.sheepy.lily.core.model.types.TypesPackage;

import org.sheepy.lily.vulkan.model.VulkanPackage;
import org.sheepy.lily.vulkan.model.impl.VulkanPackageImpl;
import org.sheepy.lily.vulkan.model.process.ProcessPackage;
import org.sheepy.lily.vulkan.model.process.compute.ComputePackage;
import org.sheepy.lily.vulkan.model.process.compute.impl.ComputePackageImpl;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage;
import org.sheepy.lily.vulkan.model.process.graphic.impl.GraphicPackageImpl;
import org.sheepy.lily.vulkan.model.process.impl.ProcessPackageImpl;
import org.sheepy.lily.vulkan.model.resource.AbstractModuleResource;
import org.sheepy.lily.vulkan.model.resource.AbstractTexture;
import org.sheepy.lily.vulkan.model.resource.BasicDescriptedResource;
import org.sheepy.lily.vulkan.model.resource.BasicResource;
import org.sheepy.lily.vulkan.model.resource.Buffer;
import org.sheepy.lily.vulkan.model.resource.BufferBarrier;
import org.sheepy.lily.vulkan.model.resource.BufferDataProvider;
import org.sheepy.lily.vulkan.model.resource.BufferReference;
import org.sheepy.lily.vulkan.model.resource.CompositeBuffer;
import org.sheepy.lily.vulkan.model.resource.CompositeBufferReference;
import org.sheepy.lily.vulkan.model.resource.ConstantBuffer;
import org.sheepy.lily.vulkan.model.resource.DescribedDataProvider;
import org.sheepy.lily.vulkan.model.resource.DescriptedResource;
import org.sheepy.lily.vulkan.model.resource.DescriptorSet;
import org.sheepy.lily.vulkan.model.resource.DescriptorSetPkg;
import org.sheepy.lily.vulkan.model.resource.FileResource;
import org.sheepy.lily.vulkan.model.resource.Font;
import org.sheepy.lily.vulkan.model.resource.GetBuffer;
import org.sheepy.lily.vulkan.model.resource.IBuffer;
import org.sheepy.lily.vulkan.model.resource.IBufferReference;
import org.sheepy.lily.vulkan.model.resource.Image;
import org.sheepy.lily.vulkan.model.resource.ImageBarrier;
import org.sheepy.lily.vulkan.model.resource.ImageLayout;
import org.sheepy.lily.vulkan.model.resource.ModuleResource;
import org.sheepy.lily.vulkan.model.resource.PathResource;
import org.sheepy.lily.vulkan.model.resource.PushBuffer;
import org.sheepy.lily.vulkan.model.resource.ResourceFactory;
import org.sheepy.lily.vulkan.model.resource.ResourcePackage;
import org.sheepy.lily.vulkan.model.resource.SampledImage;
import org.sheepy.lily.vulkan.model.resource.Sampler;
import org.sheepy.lily.vulkan.model.resource.Semaphore;
import org.sheepy.lily.vulkan.model.resource.Shader;
import org.sheepy.lily.vulkan.model.resource.StringModuleResource;
import org.sheepy.lily.vulkan.model.resource.Texture;

import org.sheepy.vulkan.model.barrier.BarrierPackage;

import org.sheepy.vulkan.model.enumeration.EnumerationPackage;
import org.sheepy.vulkan.model.graphicpipeline.GraphicpipelinePackage;
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
	private EClass basicResourceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pushBufferEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass getBufferEClass = null;

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
	private EClass descriptedResourceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass basicDescriptedResourceEClass = null;

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
	private EClass describedDataProviderEClass = null;

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
	private EClass imageLayoutEClass = null;

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
	private EClass semaphoreEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass fontEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass abstractTextureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass textureEClass = null;

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
	private EClass descriptorEClass = null;

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
	private EClass pathResourceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass fileResourceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass abstractModuleResourceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass moduleResourceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stringModuleResourceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType byteBufferEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType javaModuleEDataType = null;

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
		if (isInited) return (ResourcePackage) EPackage.Registry.INSTANCE
				.getEPackage(ResourcePackage.eNS_URI);

		// Obtain or create and register package
		Object registeredResourcePackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		ResourcePackageImpl theResourcePackage = registeredResourcePackage instanceof ResourcePackageImpl
				? (ResourcePackageImpl) registeredResourcePackage
				: new ResourcePackageImpl();

		isInited = true;

		// Initialize simple dependencies
		EcorePackage.eINSTANCE.eClass();
		TypesPackage.eINSTANCE.eClass();
		ActionPackage.eINSTANCE.eClass();
		ApplicationPackage.eINSTANCE.eClass();
		RootPackage.eINSTANCE.eClass();
		InferencePackage.eINSTANCE.eClass();
		MaintainerPackage.eINSTANCE.eClass();
		BarrierPackage.eINSTANCE.eClass();
		EnumerationPackage.eINSTANCE.eClass();
		GraphicpipelinePackage.eINSTANCE.eClass();
		PipelinePackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		Object registeredPackage = EPackage.Registry.INSTANCE.getEPackage(ComputePackage.eNS_URI);
		ComputePackageImpl theComputePackage = (ComputePackageImpl) (registeredPackage instanceof ComputePackageImpl
				? registeredPackage
				: ComputePackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(ProcessPackage.eNS_URI);
		ProcessPackageImpl theProcessPackage = (ProcessPackageImpl) (registeredPackage instanceof ProcessPackageImpl
				? registeredPackage
				: ProcessPackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(VulkanPackage.eNS_URI);
		VulkanPackageImpl theVulkanPackage = (VulkanPackageImpl) (registeredPackage instanceof VulkanPackageImpl
				? registeredPackage
				: VulkanPackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(GraphicPackage.eNS_URI);
		GraphicPackageImpl theGraphicPackage = (GraphicPackageImpl) (registeredPackage instanceof GraphicPackageImpl
				? registeredPackage
				: GraphicPackage.eINSTANCE);

		// Create package meta-data objects
		theResourcePackage.createPackageContents();
		theComputePackage.createPackageContents();
		theProcessPackage.createPackageContents();
		theVulkanPackage.createPackageContents();
		theGraphicPackage.createPackageContents();

		// Initialize created meta-data
		theResourcePackage.initializePackageContents();
		theComputePackage.initializePackageContents();
		theProcessPackage.initializePackageContents();
		theVulkanPackage.initializePackageContents();
		theGraphicPackage.initializePackageContents();

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
	public EClass getBasicResource()
	{
		return basicResourceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getPushBuffer()
	{
		return pushBufferEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getPushBuffer_BeingUpdated()
	{
		return (EAttribute) pushBufferEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getPushBuffer_Size()
	{
		return (EAttribute) pushBufferEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getPushBuffer_InstanceCount()
	{
		return (EAttribute) pushBufferEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getGetBuffer()
	{
		return getBufferEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getGetBuffer_Size()
	{
		return (EAttribute) getBufferEClass.getEStructuralFeatures().get(0);
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
	public EAttribute getConstantBuffer_BeingPushed()
	{
		return (EAttribute) constantBufferEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getConstantBuffer_Data()
	{
		return (EAttribute) constantBufferEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDescriptedResource()
	{
		return descriptedResourceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getBasicDescriptedResource()
	{
		return basicDescriptedResourceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getBasicDescriptedResource_Descriptor()
	{
		return (EReference) basicDescriptedResourceEClass.getEStructuralFeatures().get(0);
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
		return (EAttribute) bufferEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getBuffer_Usages()
	{
		return (EAttribute) bufferEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getBuffer_Data()
	{
		return (EAttribute) bufferEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getBuffer_OftenUpdated()
	{
		return (EAttribute) bufferEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getBuffer_GpuBuffer()
	{
		return (EAttribute) bufferEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getBuffer_InstanceCount()
	{
		return (EAttribute) bufferEClass.getEStructuralFeatures().get(5);
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
		return (EReference) compositeBufferEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCompositeBuffer_PushBuffer()
	{
		return (EReference) compositeBufferEClass.getEStructuralFeatures().get(1);
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
		return (EReference) bufferReferenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getBufferReference_Offset()
	{
		return (EAttribute) bufferReferenceEClass.getEStructuralFeatures().get(1);
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
		return (EReference) compositeBufferReferenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getCompositeBufferReference_Part()
	{
		return (EAttribute) compositeBufferReferenceEClass.getEStructuralFeatures().get(1);
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
	public EAttribute getBufferDataProvider_Size()
	{
		return (EAttribute) bufferDataProviderEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getBufferDataProvider_Usage()
	{
		return (EAttribute) bufferDataProviderEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getBufferDataProvider_InstanceCount()
	{
		return (EAttribute) bufferDataProviderEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDescribedDataProvider()
	{
		return describedDataProviderEClass;
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
	public EAttribute getImage_Width()
	{
		return (EAttribute) imageEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getImage_Height()
	{
		return (EAttribute) imageEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getImage_Format()
	{
		return (EAttribute) imageEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getImage_Usages()
	{
		return (EAttribute) imageEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getImage_Properties()
	{
		return (EAttribute) imageEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getImage_Tiling()
	{
		return (EAttribute) imageEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getImage_MipLevels()
	{
		return (EAttribute) imageEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getImage_InitialLayout()
	{
		return (EReference) imageEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getImage_FillWithZero()
	{
		return (EAttribute) imageEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getImageLayout()
	{
		return imageLayoutEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getImageLayout_Stage()
	{
		return (EAttribute) imageLayoutEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getImageLayout_Layout()
	{
		return (EAttribute) imageLayoutEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getImageLayout_AccessMask()
	{
		return (EAttribute) imageLayoutEClass.getEStructuralFeatures().get(2);
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
		return (EReference) sampledImageEClass.getEStructuralFeatures().get(0);
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
		return (EAttribute) semaphoreEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSemaphore_WaitStage()
	{
		return (EAttribute) semaphoreEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getFont()
	{
		return fontEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getFont_File()
	{
		return (EReference) fontEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getFont_Height()
	{
		return (EAttribute) fontEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getAbstractTexture()
	{
		return abstractTextureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAbstractTexture_MipmapEnabled()
	{
		return (EAttribute) abstractTextureEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTexture()
	{
		return textureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTexture_File()
	{
		return (EReference) textureEClass.getEStructuralFeatures().get(0);
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
	public EAttribute getSampler_MinFilter()
	{
		return (EAttribute) samplerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSampler_MagFilter()
	{
		return (EAttribute) samplerEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSampler_MipmapMode()
	{
		return (EAttribute) samplerEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSampler_AddressMode()
	{
		return (EAttribute) samplerEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSampler_BorderColor()
	{
		return (EAttribute) samplerEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSampler_AnisotropyEnabled()
	{
		return (EAttribute) samplerEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSampler_UnnormalizedCoordinates()
	{
		return (EAttribute) samplerEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSampler_CompareEnable()
	{
		return (EAttribute) samplerEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSampler_LodBias()
	{
		return (EAttribute) samplerEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSampler_MinLod()
	{
		return (EAttribute) samplerEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSampler_MaxLod()
	{
		return (EAttribute) samplerEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSampler_MaxAnisotropy()
	{
		return (EAttribute) samplerEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDescriptor()
	{
		return descriptorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDescriptor_DescriptorType()
	{
		return (EAttribute) descriptorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDescriptor_ShaderStages()
	{
		return (EAttribute) descriptorEClass.getEStructuralFeatures().get(1);
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
		return (EReference) descriptorSetEClass.getEStructuralFeatures().get(0);
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
		return (EReference) descriptorSetPkgEClass.getEStructuralFeatures().get(0);
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
		return (EReference) bufferBarrierEClass.getEStructuralFeatures().get(0);
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
		return (EReference) imageBarrierEClass.getEStructuralFeatures().get(0);
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
		return (EReference) shaderEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getShader_Stage()
	{
		return (EAttribute) shaderEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getShader_Constants()
	{
		return (EReference) shaderEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getPathResource()
	{
		return pathResourceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getPathResource_Path()
	{
		return (EAttribute) pathResourceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getFileResource()
	{
		return fileResourceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getAbstractModuleResource()
	{
		return abstractModuleResourceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getModuleResource()
	{
		return moduleResourceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getModuleResource_Module()
	{
		return (EAttribute) moduleResourceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getStringModuleResource()
	{
		return stringModuleResourceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getStringModuleResource_ModuleName()
	{
		return (EAttribute) stringModuleResourceEClass.getEStructuralFeatures().get(0);
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
	public EDataType getJavaModule()
	{
		return javaModuleEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceFactory getResourceFactory()
	{
		return (ResourceFactory) getEFactoryInstance();
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
		basicResourceEClass = createEClass(BASIC_RESOURCE);

		pushBufferEClass = createEClass(PUSH_BUFFER);
		createEAttribute(pushBufferEClass, PUSH_BUFFER__BEING_UPDATED);
		createEAttribute(pushBufferEClass, PUSH_BUFFER__SIZE);
		createEAttribute(pushBufferEClass, PUSH_BUFFER__INSTANCE_COUNT);

		getBufferEClass = createEClass(GET_BUFFER);
		createEAttribute(getBufferEClass, GET_BUFFER__SIZE);

		constantBufferEClass = createEClass(CONSTANT_BUFFER);
		createEAttribute(constantBufferEClass, CONSTANT_BUFFER__BEING_PUSHED);
		createEAttribute(constantBufferEClass, CONSTANT_BUFFER__DATA);

		descriptedResourceEClass = createEClass(DESCRIPTED_RESOURCE);

		basicDescriptedResourceEClass = createEClass(BASIC_DESCRIPTED_RESOURCE);
		createEReference(basicDescriptedResourceEClass, BASIC_DESCRIPTED_RESOURCE__DESCRIPTOR);

		iBufferEClass = createEClass(IBUFFER);

		bufferEClass = createEClass(BUFFER);
		createEAttribute(bufferEClass, BUFFER__SIZE);
		createEAttribute(bufferEClass, BUFFER__USAGES);
		createEAttribute(bufferEClass, BUFFER__DATA);
		createEAttribute(bufferEClass, BUFFER__OFTEN_UPDATED);
		createEAttribute(bufferEClass, BUFFER__GPU_BUFFER);
		createEAttribute(bufferEClass, BUFFER__INSTANCE_COUNT);

		compositeBufferEClass = createEClass(COMPOSITE_BUFFER);
		createEReference(compositeBufferEClass, COMPOSITE_BUFFER__DATA_PROVIDERS);
		createEReference(compositeBufferEClass, COMPOSITE_BUFFER__PUSH_BUFFER);

		iBufferReferenceEClass = createEClass(IBUFFER_REFERENCE);

		bufferReferenceEClass = createEClass(BUFFER_REFERENCE);
		createEReference(bufferReferenceEClass, BUFFER_REFERENCE__BUFFER);
		createEAttribute(bufferReferenceEClass, BUFFER_REFERENCE__OFFSET);

		compositeBufferReferenceEClass = createEClass(COMPOSITE_BUFFER_REFERENCE);
		createEReference(compositeBufferReferenceEClass, COMPOSITE_BUFFER_REFERENCE__BUFFER);
		createEAttribute(compositeBufferReferenceEClass, COMPOSITE_BUFFER_REFERENCE__PART);

		bufferDataProviderEClass = createEClass(BUFFER_DATA_PROVIDER);
		createEAttribute(bufferDataProviderEClass, BUFFER_DATA_PROVIDER__SIZE);
		createEAttribute(bufferDataProviderEClass, BUFFER_DATA_PROVIDER__USAGE);
		createEAttribute(bufferDataProviderEClass, BUFFER_DATA_PROVIDER__INSTANCE_COUNT);

		describedDataProviderEClass = createEClass(DESCRIBED_DATA_PROVIDER);

		imageEClass = createEClass(IMAGE);
		createEAttribute(imageEClass, IMAGE__WIDTH);
		createEAttribute(imageEClass, IMAGE__HEIGHT);
		createEAttribute(imageEClass, IMAGE__FORMAT);
		createEAttribute(imageEClass, IMAGE__USAGES);
		createEAttribute(imageEClass, IMAGE__PROPERTIES);
		createEAttribute(imageEClass, IMAGE__TILING);
		createEAttribute(imageEClass, IMAGE__MIP_LEVELS);
		createEReference(imageEClass, IMAGE__INITIAL_LAYOUT);
		createEAttribute(imageEClass, IMAGE__FILL_WITH_ZERO);

		imageLayoutEClass = createEClass(IMAGE_LAYOUT);
		createEAttribute(imageLayoutEClass, IMAGE_LAYOUT__STAGE);
		createEAttribute(imageLayoutEClass, IMAGE_LAYOUT__LAYOUT);
		createEAttribute(imageLayoutEClass, IMAGE_LAYOUT__ACCESS_MASK);

		sampledImageEClass = createEClass(SAMPLED_IMAGE);
		createEReference(sampledImageEClass, SAMPLED_IMAGE__SAMPLER);

		semaphoreEClass = createEClass(SEMAPHORE);
		createEAttribute(semaphoreEClass, SEMAPHORE__SIGNALIZED_AT_INIT);
		createEAttribute(semaphoreEClass, SEMAPHORE__WAIT_STAGE);

		fontEClass = createEClass(FONT);
		createEReference(fontEClass, FONT__FILE);
		createEAttribute(fontEClass, FONT__HEIGHT);

		abstractTextureEClass = createEClass(ABSTRACT_TEXTURE);
		createEAttribute(abstractTextureEClass, ABSTRACT_TEXTURE__MIPMAP_ENABLED);

		textureEClass = createEClass(TEXTURE);
		createEReference(textureEClass, TEXTURE__FILE);

		samplerEClass = createEClass(SAMPLER);
		createEAttribute(samplerEClass, SAMPLER__MIN_FILTER);
		createEAttribute(samplerEClass, SAMPLER__MAG_FILTER);
		createEAttribute(samplerEClass, SAMPLER__MIPMAP_MODE);
		createEAttribute(samplerEClass, SAMPLER__ADDRESS_MODE);
		createEAttribute(samplerEClass, SAMPLER__BORDER_COLOR);
		createEAttribute(samplerEClass, SAMPLER__ANISOTROPY_ENABLED);
		createEAttribute(samplerEClass, SAMPLER__UNNORMALIZED_COORDINATES);
		createEAttribute(samplerEClass, SAMPLER__COMPARE_ENABLE);
		createEAttribute(samplerEClass, SAMPLER__LOD_BIAS);
		createEAttribute(samplerEClass, SAMPLER__MIN_LOD);
		createEAttribute(samplerEClass, SAMPLER__MAX_LOD);
		createEAttribute(samplerEClass, SAMPLER__MAX_ANISOTROPY);

		descriptorEClass = createEClass(DESCRIPTOR);
		createEAttribute(descriptorEClass, DESCRIPTOR__DESCRIPTOR_TYPE);
		createEAttribute(descriptorEClass, DESCRIPTOR__SHADER_STAGES);

		descriptorSetEClass = createEClass(DESCRIPTOR_SET);
		createEReference(descriptorSetEClass, DESCRIPTOR_SET__DESCRIPTORS);

		descriptorSetPkgEClass = createEClass(DESCRIPTOR_SET_PKG);
		createEReference(descriptorSetPkgEClass, DESCRIPTOR_SET_PKG__DESCRIPTOR_SETS);

		bufferBarrierEClass = createEClass(BUFFER_BARRIER);
		createEReference(bufferBarrierEClass, BUFFER_BARRIER__BUFFER);

		imageBarrierEClass = createEClass(IMAGE_BARRIER);
		createEReference(imageBarrierEClass, IMAGE_BARRIER__IMAGE);

		shaderEClass = createEClass(SHADER);
		createEReference(shaderEClass, SHADER__FILE);
		createEAttribute(shaderEClass, SHADER__STAGE);
		createEReference(shaderEClass, SHADER__CONSTANTS);

		pathResourceEClass = createEClass(PATH_RESOURCE);
		createEAttribute(pathResourceEClass, PATH_RESOURCE__PATH);

		fileResourceEClass = createEClass(FILE_RESOURCE);

		abstractModuleResourceEClass = createEClass(ABSTRACT_MODULE_RESOURCE);

		moduleResourceEClass = createEClass(MODULE_RESOURCE);
		createEAttribute(moduleResourceEClass, MODULE_RESOURCE__MODULE);

		stringModuleResourceEClass = createEClass(STRING_MODULE_RESOURCE);
		createEAttribute(stringModuleResourceEClass, STRING_MODULE_RESOURCE__MODULE_NAME);

		// Create data types
		byteBufferEDataType = createEDataType(BYTE_BUFFER);
		javaModuleEDataType = createEDataType(JAVA_MODULE);
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
		VulkanPackage theVulkanPackage = (VulkanPackage) EPackage.Registry.INSTANCE
				.getEPackage(VulkanPackage.eNS_URI);
		EcorePackage theEcorePackage = (EcorePackage) EPackage.Registry.INSTANCE
				.getEPackage(EcorePackage.eNS_URI);
		EnumerationPackage theEnumerationPackage = (EnumerationPackage) EPackage.Registry.INSTANCE
				.getEPackage(EnumerationPackage.eNS_URI);
		TypesPackage theTypesPackage = (TypesPackage) EPackage.Registry.INSTANCE
				.getEPackage(TypesPackage.eNS_URI);
		BarrierPackage theBarrierPackage = (BarrierPackage) EPackage.Registry.INSTANCE
				.getEPackage(BarrierPackage.eNS_URI);
		PipelinePackage thePipelinePackage = (PipelinePackage) EPackage.Registry.INSTANCE
				.getEPackage(PipelinePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		basicResourceEClass.getESuperTypes().add(theVulkanPackage.getIResource());
		pushBufferEClass.getESuperTypes().add(theVulkanPackage.getIResource());
		getBufferEClass.getESuperTypes().add(theVulkanPackage.getIResource());
		constantBufferEClass.getESuperTypes().add(theVulkanPackage.getIResource());
		descriptedResourceEClass.getESuperTypes().add(theVulkanPackage.getIResource());
		basicDescriptedResourceEClass.getESuperTypes().add(this.getDescriptedResource());
		iBufferEClass.getESuperTypes().add(theVulkanPackage.getIResource());
		bufferEClass.getESuperTypes().add(this.getBasicDescriptedResource());
		bufferEClass.getESuperTypes().add(this.getIBuffer());
		compositeBufferEClass.getESuperTypes().add(this.getDescriptedResource());
		compositeBufferEClass.getESuperTypes().add(this.getIBuffer());
		bufferReferenceEClass.getESuperTypes().add(this.getIBufferReference());
		compositeBufferReferenceEClass.getESuperTypes().add(this.getIBufferReference());
		bufferDataProviderEClass.getESuperTypes().add(theTypesPackage.getLNamedElement());
		describedDataProviderEClass.getESuperTypes().add(this.getBufferDataProvider());
		describedDataProviderEClass.getESuperTypes().add(this.getDescriptor());
		imageEClass.getESuperTypes().add(this.getBasicDescriptedResource());
		sampledImageEClass.getESuperTypes().add(this.getBasicDescriptedResource());
		semaphoreEClass.getESuperTypes().add(this.getBasicResource());
		semaphoreEClass.getESuperTypes().add(theTypesPackage.getLNamedElement());
		fontEClass.getESuperTypes().add(this.getSampledImage());
		abstractTextureEClass.getESuperTypes().add(this.getSampledImage());
		textureEClass.getESuperTypes().add(this.getAbstractTexture());
		descriptorSetEClass.getESuperTypes().add(theTypesPackage.getLNamedElement());
		bufferBarrierEClass.getESuperTypes().add(theBarrierPackage.getAbstractBufferBarrier());
		imageBarrierEClass.getESuperTypes().add(theBarrierPackage.getAbstractImageBarrier());
		shaderEClass.getESuperTypes().add(this.getBasicResource());
		pathResourceEClass.getESuperTypes().add(this.getBasicResource());
		fileResourceEClass.getESuperTypes().add(this.getPathResource());
		abstractModuleResourceEClass.getESuperTypes().add(this.getPathResource());
		moduleResourceEClass.getESuperTypes().add(this.getAbstractModuleResource());
		stringModuleResourceEClass.getESuperTypes().add(this.getAbstractModuleResource());

		// Initialize classes and features; add operations and parameters
		initEClass(basicResourceEClass, BasicResource.class, "BasicResource", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(pushBufferEClass, PushBuffer.class, "PushBuffer", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPushBuffer_BeingUpdated(), theEcorePackage.getEBoolean(), "beingUpdated",
				"false", 0, 1, PushBuffer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPushBuffer_Size(), theEcorePackage.getELong(), "size", null, 0, 1,
				PushBuffer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE,
				!IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPushBuffer_InstanceCount(), theEcorePackage.getEInt(), "instanceCount",
				"3", 0, 1, PushBuffer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(getBufferEClass, GetBuffer.class, "GetBuffer", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getGetBuffer_Size(), theEcorePackage.getELong(), "size", null, 0, 1,
				GetBuffer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
				!IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(constantBufferEClass, ConstantBuffer.class, "ConstantBuffer", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getConstantBuffer_BeingPushed(), theEcorePackage.getEBoolean(),
				"beingPushed", "false", 0, 1, ConstantBuffer.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConstantBuffer_Data(), this.getByteBuffer(), "data", null, 0, 1,
				ConstantBuffer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE,
				!IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(descriptedResourceEClass, DescriptedResource.class, "DescriptedResource",
				IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(basicDescriptedResourceEClass, BasicDescriptedResource.class,
				"BasicDescriptedResource", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBasicDescriptedResource_Descriptor(), this.getDescriptor(), null,
				"descriptor", null, 0, 1, BasicDescriptedResource.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(iBufferEClass, IBuffer.class, "IBuffer", IS_ABSTRACT, IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);

		initEClass(bufferEClass, Buffer.class, "Buffer", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getBuffer_Size(), theEcorePackage.getELong(), "size", null, 0, 1,
				Buffer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
				!IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBuffer_Usages(), theEnumerationPackage.getEBufferUsage(), "usages", null,
				0, -1, Buffer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE,
				!IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBuffer_Data(), this.getByteBuffer(), "data", null, 0, 1, Buffer.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEAttribute(getBuffer_OftenUpdated(), theEcorePackage.getEBoolean(), "oftenUpdated",
				"false", 0, 1, Buffer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBuffer_GpuBuffer(), theEcorePackage.getEBoolean(), "gpuBuffer", "true", 0,
				1, Buffer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
				!IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBuffer_InstanceCount(), theEcorePackage.getEInt(), "instanceCount", "1",
				0, 1, Buffer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE,
				!IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(compositeBufferEClass, CompositeBuffer.class, "CompositeBuffer", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCompositeBuffer_DataProviders(), this.getBufferDataProvider(), null,
				"dataProviders", null, 0, -1, CompositeBuffer.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEReference(getCompositeBuffer_PushBuffer(), this.getPushBuffer(), null, "pushBuffer",
				null, 1, 1, CompositeBuffer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);

		initEClass(iBufferReferenceEClass, IBufferReference.class, "IBufferReference", IS_ABSTRACT,
				IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(bufferReferenceEClass, BufferReference.class, "BufferReference", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBufferReference_Buffer(), this.getBuffer(), null, "buffer", null, 1, 1,
				BufferReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBufferReference_Offset(), theEcorePackage.getELong(), "offset", null, 0,
				1, BufferReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(compositeBufferReferenceEClass, CompositeBufferReference.class,
				"CompositeBufferReference", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCompositeBufferReference_Buffer(), this.getCompositeBuffer(), null,
				"buffer", null, 1, 1, CompositeBufferReference.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEAttribute(getCompositeBufferReference_Part(), theEcorePackage.getEInt(), "part", null,
				0, 1, CompositeBufferReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(bufferDataProviderEClass, BufferDataProvider.class, "BufferDataProvider",
				!IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getBufferDataProvider_Size(), theEcorePackage.getELong(), "size", null, 0, 1,
				BufferDataProvider.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBufferDataProvider_Usage(), theEnumerationPackage.getEBufferUsage(),
				"usage", null, 0, 1, BufferDataProvider.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBufferDataProvider_InstanceCount(), theEcorePackage.getEInt(),
				"instanceCount", "1", 0, 1, BufferDataProvider.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(describedDataProviderEClass, DescribedDataProvider.class,
				"DescribedDataProvider", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(imageEClass, Image.class, "Image", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getImage_Width(), theEcorePackage.getEInt(), "width", null, 0, 1,
				Image.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
				!IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getImage_Height(), theEcorePackage.getEInt(), "height", null, 0, 1,
				Image.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
				!IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getImage_Format(), theEnumerationPackage.getEFormat(), "format", null, 0, 1,
				Image.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
				!IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getImage_Usages(), theEnumerationPackage.getEImageUsage(), "usages", null, 0,
				-1, Image.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getImage_Properties(), theEcorePackage.getEInt(), "properties", null, 0, 1,
				Image.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
				!IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getImage_Tiling(), theEcorePackage.getEInt(), "tiling", "0", 0, 1,
				Image.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
				!IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getImage_MipLevels(), theEcorePackage.getEInt(), "mipLevels", "1", 0, 1,
				Image.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
				!IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getImage_InitialLayout(), this.getImageLayout(), null, "initialLayout", null,
				0, 1, Image.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
				!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getImage_FillWithZero(), theEcorePackage.getEBoolean(), "fillWithZero",
				"false", 0, 1, Image.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(imageLayoutEClass, ImageLayout.class, "ImageLayout", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getImageLayout_Stage(), theEnumerationPackage.getEPipelineStage(), "stage",
				null, 0, 1, ImageLayout.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getImageLayout_Layout(), theEnumerationPackage.getEImageLayout(), "layout",
				null, 0, 1, ImageLayout.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getImageLayout_AccessMask(), theEnumerationPackage.getEAccess(),
				"accessMask", null, 0, -1, ImageLayout.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(sampledImageEClass, SampledImage.class, "SampledImage", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSampledImage_Sampler(), this.getSampler(), null, "sampler", null, 0, 1,
				SampledImage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
				!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(semaphoreEClass, Semaphore.class, "Semaphore", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSemaphore_SignalizedAtInit(), theEcorePackage.getEBoolean(),
				"signalizedAtInit", "false", 0, 1, Semaphore.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSemaphore_WaitStage(), theEnumerationPackage.getEPipelineStage(),
				"waitStage", null, 0, 1, Semaphore.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(fontEClass, Font.class, "Font", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFont_File(), this.getPathResource(), null, "file", null, 0, 1, Font.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFont_Height(), theEcorePackage.getEInt(), "height", "18", 0, 1,
				Font.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
				!IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(abstractTextureEClass, AbstractTexture.class, "AbstractTexture", IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAbstractTexture_MipmapEnabled(), theEcorePackage.getEBoolean(),
				"mipmapEnabled", "false", 0, 1, AbstractTexture.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(textureEClass, Texture.class, "Texture", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTexture_File(), this.getPathResource(), null, "file", null, 0, 1,
				Texture.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
				!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(samplerEClass, Sampler.class, "Sampler", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSampler_MinFilter(), theEnumerationPackage.getEFilter(), "minFilter",
				"NEAREST", 0, 1, Sampler.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSampler_MagFilter(), theEnumerationPackage.getEFilter(), "magFilter",
				"NEAREST", 0, 1, Sampler.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSampler_MipmapMode(), theEnumerationPackage.getESamplerMipmapMode(),
				"mipmapMode", "NEAREST", 0, 1, Sampler.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSampler_AddressMode(), theEnumerationPackage.getESamplerAddressMode(),
				"addressMode", "REPEAT", 0, 1, Sampler.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSampler_BorderColor(), theEnumerationPackage.getEBorderColor(),
				"borderColor", "INT_OPAQUE_BLACK", 0, 1, Sampler.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSampler_AnisotropyEnabled(), theEcorePackage.getEBoolean(),
				"anisotropyEnabled", "false", 0, 1, Sampler.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSampler_UnnormalizedCoordinates(), theEcorePackage.getEBoolean(),
				"unnormalizedCoordinates", "false", 0, 1, Sampler.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);
		initEAttribute(getSampler_CompareEnable(), theEcorePackage.getEBoolean(), "compareEnable",
				"false", 0, 1, Sampler.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSampler_LodBias(), theEcorePackage.getEFloat(), "lodBias", "0", 0, 1,
				Sampler.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
				!IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSampler_MinLod(), theEcorePackage.getEInt(), "minLod", "0", 0, 1,
				Sampler.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
				!IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSampler_MaxLod(), theEcorePackage.getEInt(), "maxLod", "1", 0, 1,
				Sampler.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
				!IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSampler_MaxAnisotropy(), theEcorePackage.getEFloat(), "maxAnisotropy",
				"1", 0, 1, Sampler.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(descriptorEClass, org.sheepy.lily.vulkan.model.resource.Descriptor.class,
				"Descriptor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDescriptor_DescriptorType(), theEnumerationPackage.getEDescriptorType(),
				"descriptorType", null, 0, 1,
				org.sheepy.lily.vulkan.model.resource.Descriptor.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDescriptor_ShaderStages(), theEnumerationPackage.getEShaderStage(),
				"shaderStages", null, 0, -1, org.sheepy.lily.vulkan.model.resource.Descriptor.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);

		initEClass(descriptorSetEClass, DescriptorSet.class, "DescriptorSet", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDescriptorSet_Descriptors(), this.getDescriptedResource(), null,
				"descriptors", null, 1, -1, DescriptorSet.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);

		initEClass(descriptorSetPkgEClass, DescriptorSetPkg.class, "DescriptorSetPkg", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDescriptorSetPkg_DescriptorSets(), this.getDescriptorSet(), null,
				"descriptorSets", null, 0, -1, DescriptorSetPkg.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);

		initEClass(bufferBarrierEClass, BufferBarrier.class, "BufferBarrier", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBufferBarrier_Buffer(), this.getBuffer(), null, "buffer", null, 0, 1,
				BufferBarrier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(imageBarrierEClass, ImageBarrier.class, "ImageBarrier", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getImageBarrier_Image(), this.getImage(), null, "image", null, 0, 1,
				ImageBarrier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(shaderEClass, Shader.class, "Shader", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getShader_File(), this.getPathResource(), null, "file", null, 0, 1,
				Shader.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
				!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getShader_Stage(), theEnumerationPackage.getEShaderStage(), "stage", null, 0,
				1, Shader.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
				!IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getShader_Constants(), thePipelinePackage.getSpecializationConstant(), null,
				"constants", null, 1, -1, Shader.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);

		initEClass(pathResourceEClass, PathResource.class, "PathResource", IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPathResource_Path(), theEcorePackage.getEString(), "path", null, 0, 1,
				PathResource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE,
				!IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(fileResourceEClass, FileResource.class, "FileResource", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(abstractModuleResourceEClass, AbstractModuleResource.class,
				"AbstractModuleResource", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(moduleResourceEClass, ModuleResource.class, "ModuleResource", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getModuleResource_Module(), this.getJavaModule(), "module", null, 0, 1,
				ModuleResource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE,
				!IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(stringModuleResourceEClass, StringModuleResource.class, "StringModuleResource",
				!IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getStringModuleResource_ModuleName(), theEcorePackage.getEString(),
				"moduleName", null, 0, 1, StringModuleResource.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize data types
		initEDataType(byteBufferEDataType, ByteBuffer.class, "ByteBuffer", IS_SERIALIZABLE,
				!IS_GENERATED_INSTANCE_CLASS);
		initEDataType(javaModuleEDataType, Module.class, "JavaModule", IS_SERIALIZABLE,
				!IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //ResourcePackageImpl
