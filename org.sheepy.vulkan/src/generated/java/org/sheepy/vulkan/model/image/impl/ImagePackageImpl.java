/**
 */
package org.sheepy.vulkan.model.image.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.sheepy.lily.core.model.types.TypesPackage;
import org.sheepy.vulkan.model.barrier.BarrierPackage;

import org.sheepy.vulkan.model.barrier.impl.BarrierPackageImpl;

import org.sheepy.vulkan.model.enumeration.EnumerationPackage;

import org.sheepy.vulkan.model.enumeration.impl.EnumerationPackageImpl;

import org.sheepy.vulkan.model.graphicpipeline.GraphicpipelinePackage;

import org.sheepy.vulkan.model.graphicpipeline.impl.GraphicpipelinePackageImpl;

import org.sheepy.vulkan.model.image.ImageFactory;
import org.sheepy.vulkan.model.image.ImageInfo;
import org.sheepy.vulkan.model.image.ImageLayout;
import org.sheepy.vulkan.model.image.ImagePackage;
import org.sheepy.vulkan.model.image.SamplerInfo;
import org.sheepy.vulkan.model.pipeline.PipelinePackage;

import org.sheepy.vulkan.model.pipeline.impl.PipelinePackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ImagePackageImpl extends EPackageImpl implements ImagePackage
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass samplerInfoEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass imageInfoEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass imageLayoutEClass = null;

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
	 * @see org.sheepy.vulkan.model.image.ImagePackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ImagePackageImpl()
	{
		super(eNS_URI, ImageFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link ImagePackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ImagePackage init()
	{
		if (isInited) return (ImagePackage)EPackage.Registry.INSTANCE.getEPackage(ImagePackage.eNS_URI);

		// Obtain or create and register package
		Object registeredImagePackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		ImagePackageImpl theImagePackage = registeredImagePackage instanceof ImagePackageImpl ? (ImagePackageImpl)registeredImagePackage : new ImagePackageImpl();

		isInited = true;

		// Initialize simple dependencies
		TypesPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		Object registeredPackage = EPackage.Registry.INSTANCE.getEPackage(BarrierPackage.eNS_URI);
		BarrierPackageImpl theBarrierPackage = (BarrierPackageImpl)(registeredPackage instanceof BarrierPackageImpl ? registeredPackage : BarrierPackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(EnumerationPackage.eNS_URI);
		EnumerationPackageImpl theEnumerationPackage = (EnumerationPackageImpl)(registeredPackage instanceof EnumerationPackageImpl ? registeredPackage : EnumerationPackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(GraphicpipelinePackage.eNS_URI);
		GraphicpipelinePackageImpl theGraphicpipelinePackage = (GraphicpipelinePackageImpl)(registeredPackage instanceof GraphicpipelinePackageImpl ? registeredPackage : GraphicpipelinePackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(PipelinePackage.eNS_URI);
		PipelinePackageImpl thePipelinePackage = (PipelinePackageImpl)(registeredPackage instanceof PipelinePackageImpl ? registeredPackage : PipelinePackage.eINSTANCE);

		// Create package meta-data objects
		theImagePackage.createPackageContents();
		theBarrierPackage.createPackageContents();
		theEnumerationPackage.createPackageContents();
		theGraphicpipelinePackage.createPackageContents();
		thePipelinePackage.createPackageContents();

		// Initialize created meta-data
		theImagePackage.initializePackageContents();
		theBarrierPackage.initializePackageContents();
		theEnumerationPackage.initializePackageContents();
		theGraphicpipelinePackage.initializePackageContents();
		thePipelinePackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theImagePackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ImagePackage.eNS_URI, theImagePackage);
		return theImagePackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getSamplerInfo()
	{
		return samplerInfoEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSamplerInfo_MinFilter()
	{
		return (EAttribute)samplerInfoEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSamplerInfo_MagFilter()
	{
		return (EAttribute)samplerInfoEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSamplerInfo_MipmapMode()
	{
		return (EAttribute)samplerInfoEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSamplerInfo_AddressMode()
	{
		return (EAttribute)samplerInfoEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSamplerInfo_BorderColor()
	{
		return (EAttribute)samplerInfoEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSamplerInfo_AnisotropyEnabled()
	{
		return (EAttribute)samplerInfoEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSamplerInfo_UnnormalizedCoordinates()
	{
		return (EAttribute)samplerInfoEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSamplerInfo_CompareEnable()
	{
		return (EAttribute)samplerInfoEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSamplerInfo_LodBias()
	{
		return (EAttribute)samplerInfoEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSamplerInfo_MinLod()
	{
		return (EAttribute)samplerInfoEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSamplerInfo_MaxLod()
	{
		return (EAttribute)samplerInfoEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSamplerInfo_MaxAnisotropy()
	{
		return (EAttribute)samplerInfoEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getImageInfo()
	{
		return imageInfoEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getImageInfo_Format()
	{
		return (EAttribute)imageInfoEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getImageInfo_Usages()
	{
		return (EAttribute)imageInfoEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getImageInfo_Tiling()
	{
		return (EAttribute)imageInfoEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getImageInfo_MipLevels()
	{
		return (EAttribute)imageInfoEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getImageInfo_InitialLayout()
	{
		return (EReference)imageInfoEClass.getEStructuralFeatures().get(4);
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
		return (EAttribute)imageLayoutEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getImageLayout_Layout()
	{
		return (EAttribute)imageLayoutEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getImageLayout_AccessMask()
	{
		return (EAttribute)imageLayoutEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ImageFactory getImageFactory()
	{
		return (ImageFactory)getEFactoryInstance();
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
		samplerInfoEClass = createEClass(SAMPLER_INFO);
		createEAttribute(samplerInfoEClass, SAMPLER_INFO__MIN_FILTER);
		createEAttribute(samplerInfoEClass, SAMPLER_INFO__MAG_FILTER);
		createEAttribute(samplerInfoEClass, SAMPLER_INFO__MIPMAP_MODE);
		createEAttribute(samplerInfoEClass, SAMPLER_INFO__ADDRESS_MODE);
		createEAttribute(samplerInfoEClass, SAMPLER_INFO__BORDER_COLOR);
		createEAttribute(samplerInfoEClass, SAMPLER_INFO__ANISOTROPY_ENABLED);
		createEAttribute(samplerInfoEClass, SAMPLER_INFO__UNNORMALIZED_COORDINATES);
		createEAttribute(samplerInfoEClass, SAMPLER_INFO__COMPARE_ENABLE);
		createEAttribute(samplerInfoEClass, SAMPLER_INFO__LOD_BIAS);
		createEAttribute(samplerInfoEClass, SAMPLER_INFO__MIN_LOD);
		createEAttribute(samplerInfoEClass, SAMPLER_INFO__MAX_LOD);
		createEAttribute(samplerInfoEClass, SAMPLER_INFO__MAX_ANISOTROPY);

		imageInfoEClass = createEClass(IMAGE_INFO);
		createEAttribute(imageInfoEClass, IMAGE_INFO__FORMAT);
		createEAttribute(imageInfoEClass, IMAGE_INFO__USAGES);
		createEAttribute(imageInfoEClass, IMAGE_INFO__TILING);
		createEAttribute(imageInfoEClass, IMAGE_INFO__MIP_LEVELS);
		createEReference(imageInfoEClass, IMAGE_INFO__INITIAL_LAYOUT);

		imageLayoutEClass = createEClass(IMAGE_LAYOUT);
		createEAttribute(imageLayoutEClass, IMAGE_LAYOUT__STAGE);
		createEAttribute(imageLayoutEClass, IMAGE_LAYOUT__LAYOUT);
		createEAttribute(imageLayoutEClass, IMAGE_LAYOUT__ACCESS_MASK);
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
		EnumerationPackage theEnumerationPackage = (EnumerationPackage)EPackage.Registry.INSTANCE.getEPackage(EnumerationPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes, features, and operations; add parameters
		initEClass(samplerInfoEClass, SamplerInfo.class, "SamplerInfo", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSamplerInfo_MinFilter(), theEnumerationPackage.getEFilter(), "minFilter", "NEAREST", 0, 1, SamplerInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSamplerInfo_MagFilter(), theEnumerationPackage.getEFilter(), "magFilter", "NEAREST", 0, 1, SamplerInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSamplerInfo_MipmapMode(), theEnumerationPackage.getESamplerMipmapMode(), "mipmapMode", "NEAREST", 0, 1, SamplerInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSamplerInfo_AddressMode(), theEnumerationPackage.getESamplerAddressMode(), "addressMode", "REPEAT", 0, 1, SamplerInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSamplerInfo_BorderColor(), theEnumerationPackage.getEBorderColor(), "borderColor", "INT_OPAQUE_BLACK", 0, 1, SamplerInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSamplerInfo_AnisotropyEnabled(), ecorePackage.getEBoolean(), "anisotropyEnabled", "false", 0, 1, SamplerInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSamplerInfo_UnnormalizedCoordinates(), ecorePackage.getEBoolean(), "unnormalizedCoordinates", "false", 0, 1, SamplerInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSamplerInfo_CompareEnable(), ecorePackage.getEBoolean(), "compareEnable", "false", 0, 1, SamplerInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSamplerInfo_LodBias(), ecorePackage.getEFloat(), "lodBias", "0", 0, 1, SamplerInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSamplerInfo_MinLod(), ecorePackage.getEInt(), "minLod", "0", 0, 1, SamplerInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSamplerInfo_MaxLod(), ecorePackage.getEInt(), "maxLod", "1", 0, 1, SamplerInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSamplerInfo_MaxAnisotropy(), ecorePackage.getEFloat(), "maxAnisotropy", "1", 0, 1, SamplerInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(imageInfoEClass, ImageInfo.class, "ImageInfo", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getImageInfo_Format(), theEnumerationPackage.getEFormat(), "format", "R8G8B8A8_UNORM", 1, 1, ImageInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getImageInfo_Usages(), theEnumerationPackage.getEImageUsage(), "usages", null, 1, -1, ImageInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getImageInfo_Tiling(), ecorePackage.getEInt(), "tiling", "0", 1, 1, ImageInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getImageInfo_MipLevels(), ecorePackage.getEInt(), "mipLevels", "1", 1, 1, ImageInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getImageInfo_InitialLayout(), this.getImageLayout(), null, "initialLayout", null, 0, 1, ImageInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(imageLayoutEClass, ImageLayout.class, "ImageLayout", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getImageLayout_Stage(), theEnumerationPackage.getEPipelineStage(), "stage", null, 0, 1, ImageLayout.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getImageLayout_Layout(), theEnumerationPackage.getEImageLayout(), "layout", "SHADER_READ_ONLY_OPTIMAL", 0, 1, ImageLayout.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getImageLayout_AccessMask(), theEnumerationPackage.getEAccess(), "accessMask", null, 0, -1, ImageLayout.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //ImagePackageImpl
