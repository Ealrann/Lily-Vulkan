/**
 */
package org.sheepy.lily.vulkan.extra.graphic.model.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.sheepy.lily.core.model.action.ActionPackage;

import org.sheepy.lily.core.model.application.ApplicationPackage;

import org.sheepy.lily.core.model.inference.InferencePackage;

import org.sheepy.lily.core.model.root.RootPackage;

import org.sheepy.lily.core.model.types.TypesPackage;

import org.sheepy.lily.vulkan.extra.graphic.model.GraphicExtraFactory;
import org.sheepy.lily.vulkan.extra.graphic.model.GraphicExtraPackage;
import org.sheepy.lily.vulkan.extra.graphic.model.IMeshProvider;
import org.sheepy.lily.vulkan.extra.graphic.model.ImagePipeline;

import org.sheepy.lily.vulkan.extra.graphic.model.ScreenRenderer;
import org.sheepy.lily.vulkan.extra.graphic.model.TerrainRenderer;
import org.sheepy.lily.vulkan.model.VulkanPackage;

import org.sheepy.lily.vulkan.model.enumeration.EnumerationPackage;

import org.sheepy.lily.vulkan.model.process.ProcessPackage;

import org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage;
import org.sheepy.lily.vulkan.model.resource.ResourcePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class GraphicExtraPackageImpl extends EPackageImpl implements GraphicExtraPackage
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass imagePipelineEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass terrainRendererEClass = null;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iMeshProviderEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass screenRendererEClass = null;

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
	 * @see org.sheepy.lily.vulkan.extra.graphic.model.GraphicExtraPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private GraphicExtraPackageImpl()
	{
		super(eNS_URI, GraphicExtraFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link GraphicExtraPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static GraphicExtraPackage init()
	{
		if (isInited) return (GraphicExtraPackage) EPackage.Registry.INSTANCE
				.getEPackage(GraphicExtraPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredGraphicExtraPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		GraphicExtraPackageImpl theGraphicExtraPackage = registeredGraphicExtraPackage instanceof GraphicExtraPackageImpl
				? (GraphicExtraPackageImpl) registeredGraphicExtraPackage
				: new GraphicExtraPackageImpl();

		isInited = true;

		// Initialize simple dependencies
		ProcessPackage.eINSTANCE.eClass();
		RootPackage.eINSTANCE.eClass();
		TypesPackage.eINSTANCE.eClass();
		VulkanPackage.eINSTANCE.eClass();
		InferencePackage.eINSTANCE.eClass();
		ResourcePackage.eINSTANCE.eClass();
		EnumerationPackage.eINSTANCE.eClass();
		GraphicPackage.eINSTANCE.eClass();
		EcorePackage.eINSTANCE.eClass();
		ActionPackage.eINSTANCE.eClass();
		ApplicationPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theGraphicExtraPackage.createPackageContents();

		// Initialize created meta-data
		theGraphicExtraPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theGraphicExtraPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(GraphicExtraPackage.eNS_URI, theGraphicExtraPackage);
		return theGraphicExtraPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getImagePipeline()
	{
		return imagePipelineEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getImagePipeline_Image()
	{
		return (EReference) imagePipelineEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getImagePipeline_ImageSrcStage()
	{
		return (EAttribute) imagePipelineEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getImagePipeline_ImageDstStage()
	{
		return (EAttribute) imagePipelineEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getImagePipeline_ImageSrcAccessMask()
	{
		return (EAttribute) imagePipelineEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getImagePipeline_ImageDstAccessMask()
	{
		return (EAttribute) imagePipelineEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getImagePipeline_SrcQueue()
	{
		return (EReference) imagePipelineEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTerrainRenderer()
	{
		return terrainRendererEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTerrainRenderer_MeshProvider()
	{
		return (EReference) terrainRendererEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getIMeshProvider()
	{
		return iMeshProviderEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getScreenRenderer()
	{
		return screenRendererEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public GraphicExtraFactory getGraphicExtraFactory()
	{
		return (GraphicExtraFactory) getEFactoryInstance();
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
		imagePipelineEClass = createEClass(IMAGE_PIPELINE);
		createEReference(imagePipelineEClass, IMAGE_PIPELINE__IMAGE);
		createEAttribute(imagePipelineEClass, IMAGE_PIPELINE__IMAGE_SRC_STAGE);
		createEAttribute(imagePipelineEClass, IMAGE_PIPELINE__IMAGE_DST_STAGE);
		createEAttribute(imagePipelineEClass, IMAGE_PIPELINE__IMAGE_SRC_ACCESS_MASK);
		createEAttribute(imagePipelineEClass, IMAGE_PIPELINE__IMAGE_DST_ACCESS_MASK);
		createEReference(imagePipelineEClass, IMAGE_PIPELINE__SRC_QUEUE);

		terrainRendererEClass = createEClass(TERRAIN_RENDERER);
		createEReference(terrainRendererEClass, TERRAIN_RENDERER__MESH_PROVIDER);

		iMeshProviderEClass = createEClass(IMESH_PROVIDER);

		screenRendererEClass = createEClass(SCREEN_RENDERER);
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
		ProcessPackage theProcessPackage = (ProcessPackage) EPackage.Registry.INSTANCE
				.getEPackage(ProcessPackage.eNS_URI);
		ResourcePackage theResourcePackage = (ResourcePackage) EPackage.Registry.INSTANCE
				.getEPackage(ResourcePackage.eNS_URI);
		EnumerationPackage theEnumerationPackage = (EnumerationPackage) EPackage.Registry.INSTANCE
				.getEPackage(EnumerationPackage.eNS_URI);
		GraphicPackage theGraphicPackage = (GraphicPackage) EPackage.Registry.INSTANCE
				.getEPackage(GraphicPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		imagePipelineEClass.getESuperTypes().add(theProcessPackage.getAbstractPipeline());
		terrainRendererEClass.getESuperTypes().add(theGraphicPackage.getGraphicsPipeline());
		terrainRendererEClass.getESuperTypes().add(theProcessPackage.getIPipeline());
		screenRendererEClass.getESuperTypes().add(theGraphicPackage.getGraphicsPipeline());
		screenRendererEClass.getESuperTypes().add(theProcessPackage.getIPipeline());

		// Initialize classes, features, and operations; add parameters
		initEClass(imagePipelineEClass, ImagePipeline.class, "ImagePipeline", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getImagePipeline_Image(), theResourcePackage.getImage(), null, "image", null,
				1, 1, ImagePipeline.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);
		initEAttribute(getImagePipeline_ImageSrcStage(), theEnumerationPackage.getEPipelineStage(),
				"imageSrcStage", null, 0, 1, ImagePipeline.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getImagePipeline_ImageDstStage(), theEnumerationPackage.getEPipelineStage(),
				"imageDstStage", null, 0, 1, ImagePipeline.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getImagePipeline_ImageSrcAccessMask(), theEnumerationPackage.getEAccess(),
				"imageSrcAccessMask", null, 0, -1, ImagePipeline.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getImagePipeline_ImageDstAccessMask(), theEnumerationPackage.getEAccess(),
				"imageDstAccessMask", null, 0, -1, ImagePipeline.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getImagePipeline_SrcQueue(), theProcessPackage.getAbstractProcess(), null,
				"srcQueue", null, 0, 1, ImagePipeline.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);

		initEClass(terrainRendererEClass, TerrainRenderer.class, "TerrainRenderer", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTerrainRenderer_MeshProvider(), this.getIMeshProvider(), null,
				"meshProvider", null, 0, 1, TerrainRenderer.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);

		initEClass(iMeshProviderEClass, IMeshProvider.class, "IMeshProvider", IS_ABSTRACT,
				IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(screenRendererEClass, ScreenRenderer.class, "ScreenRenderer", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //GraphicExtraPackageImpl
