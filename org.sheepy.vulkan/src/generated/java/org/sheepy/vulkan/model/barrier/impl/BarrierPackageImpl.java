/**
 */
package org.sheepy.vulkan.model.barrier.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.sheepy.vulkan.model.barrier.AbstractBufferBarrier;
import org.sheepy.vulkan.model.barrier.AbstractImageBarrier;
import org.sheepy.vulkan.model.barrier.Barrier;
import org.sheepy.vulkan.model.barrier.BarrierFactory;
import org.sheepy.vulkan.model.barrier.BarrierPackage;
import org.sheepy.vulkan.model.barrier.ImageTransition;
import org.sheepy.vulkan.model.barrier.ReferenceBufferBarrier;
import org.sheepy.vulkan.model.barrier.ReferenceImageBarrier;

import org.sheepy.vulkan.model.enumeration.EnumerationPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class BarrierPackageImpl extends EPackageImpl implements BarrierPackage
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass barrierEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass abstractBufferBarrierEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass referenceBufferBarrierEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass abstractImageBarrierEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass referenceImageBarrierEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass imageTransitionEClass = null;

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
	 * @see org.sheepy.vulkan.model.barrier.BarrierPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private BarrierPackageImpl()
	{
		super(eNS_URI, BarrierFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link BarrierPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static BarrierPackage init()
	{
		if (isInited)
			return (BarrierPackage) EPackage.Registry.INSTANCE.getEPackage(BarrierPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredBarrierPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		BarrierPackageImpl theBarrierPackage = registeredBarrierPackage instanceof BarrierPackageImpl
				? (BarrierPackageImpl) registeredBarrierPackage
				: new BarrierPackageImpl();

		isInited = true;

		// Initialize simple dependencies
		EnumerationPackage.eINSTANCE.eClass();
		EcorePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theBarrierPackage.createPackageContents();

		// Initialize created meta-data
		theBarrierPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theBarrierPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(BarrierPackage.eNS_URI, theBarrierPackage);
		return theBarrierPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getBarrier()
	{
		return barrierEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getBarrier_SrcStage()
	{
		return (EAttribute) barrierEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getBarrier_DstStage()
	{
		return (EAttribute) barrierEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getAbstractBufferBarrier()
	{
		return abstractBufferBarrierEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAbstractBufferBarrier_SrcAccess()
	{
		return (EAttribute) abstractBufferBarrierEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAbstractBufferBarrier_DstAccess()
	{
		return (EAttribute) abstractBufferBarrierEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getReferenceBufferBarrier()
	{
		return referenceBufferBarrierEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getReferenceBufferBarrier_BufferAddress()
	{
		return (EAttribute) referenceBufferBarrierEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getAbstractImageBarrier()
	{
		return abstractImageBarrierEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getAbstractImageBarrier_Transitions()
	{
		return (EReference) abstractImageBarrierEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getReferenceImageBarrier()
	{
		return referenceImageBarrierEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getReferenceImageBarrier_ImageId()
	{
		return (EAttribute) referenceImageBarrierEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getReferenceImageBarrier_MipLevels()
	{
		return (EAttribute) referenceImageBarrierEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getReferenceImageBarrier_ImageFormat()
	{
		return (EAttribute) referenceImageBarrierEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getImageTransition()
	{
		return imageTransitionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getImageTransition_SrcLayout()
	{
		return (EAttribute) imageTransitionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getImageTransition_DstLayout()
	{
		return (EAttribute) imageTransitionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getImageTransition_SrcAccessMask()
	{
		return (EAttribute) imageTransitionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getImageTransition_DstAccessMask()
	{
		return (EAttribute) imageTransitionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public BarrierFactory getBarrierFactory()
	{
		return (BarrierFactory) getEFactoryInstance();
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
		barrierEClass = createEClass(BARRIER);
		createEAttribute(barrierEClass, BARRIER__SRC_STAGE);
		createEAttribute(barrierEClass, BARRIER__DST_STAGE);

		abstractBufferBarrierEClass = createEClass(ABSTRACT_BUFFER_BARRIER);
		createEAttribute(abstractBufferBarrierEClass, ABSTRACT_BUFFER_BARRIER__SRC_ACCESS);
		createEAttribute(abstractBufferBarrierEClass, ABSTRACT_BUFFER_BARRIER__DST_ACCESS);

		referenceBufferBarrierEClass = createEClass(REFERENCE_BUFFER_BARRIER);
		createEAttribute(referenceBufferBarrierEClass, REFERENCE_BUFFER_BARRIER__BUFFER_ADDRESS);

		abstractImageBarrierEClass = createEClass(ABSTRACT_IMAGE_BARRIER);
		createEReference(abstractImageBarrierEClass, ABSTRACT_IMAGE_BARRIER__TRANSITIONS);

		referenceImageBarrierEClass = createEClass(REFERENCE_IMAGE_BARRIER);
		createEAttribute(referenceImageBarrierEClass, REFERENCE_IMAGE_BARRIER__IMAGE_ID);
		createEAttribute(referenceImageBarrierEClass, REFERENCE_IMAGE_BARRIER__MIP_LEVELS);
		createEAttribute(referenceImageBarrierEClass, REFERENCE_IMAGE_BARRIER__IMAGE_FORMAT);

		imageTransitionEClass = createEClass(IMAGE_TRANSITION);
		createEAttribute(imageTransitionEClass, IMAGE_TRANSITION__SRC_LAYOUT);
		createEAttribute(imageTransitionEClass, IMAGE_TRANSITION__DST_LAYOUT);
		createEAttribute(imageTransitionEClass, IMAGE_TRANSITION__SRC_ACCESS_MASK);
		createEAttribute(imageTransitionEClass, IMAGE_TRANSITION__DST_ACCESS_MASK);
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
		EnumerationPackage theEnumerationPackage = (EnumerationPackage) EPackage.Registry.INSTANCE
				.getEPackage(EnumerationPackage.eNS_URI);
		EcorePackage theEcorePackage = (EcorePackage) EPackage.Registry.INSTANCE
				.getEPackage(EcorePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		abstractBufferBarrierEClass.getESuperTypes().add(this.getBarrier());
		referenceBufferBarrierEClass.getESuperTypes().add(this.getAbstractBufferBarrier());
		abstractImageBarrierEClass.getESuperTypes().add(this.getBarrier());
		referenceImageBarrierEClass.getESuperTypes().add(this.getAbstractImageBarrier());

		// Initialize classes, features, and operations; add parameters
		initEClass(barrierEClass, Barrier.class, "Barrier", IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getBarrier_SrcStage(), theEnumerationPackage.getEPipelineStage(), "srcStage",
				null, 0, 1, Barrier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBarrier_DstStage(), theEnumerationPackage.getEPipelineStage(), "dstStage",
				null, 0, 1, Barrier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(abstractBufferBarrierEClass, AbstractBufferBarrier.class,
				"AbstractBufferBarrier", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAbstractBufferBarrier_SrcAccess(), theEnumerationPackage.getEAccess(),
				"srcAccess", null, 0, 1, AbstractBufferBarrier.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAbstractBufferBarrier_DstAccess(), theEnumerationPackage.getEAccess(),
				"dstAccess", null, 0, 1, AbstractBufferBarrier.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(referenceBufferBarrierEClass, ReferenceBufferBarrier.class,
				"ReferenceBufferBarrier", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getReferenceBufferBarrier_BufferAddress(), theEcorePackage.getELong(),
				"bufferAddress", null, 0, 1, ReferenceBufferBarrier.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);

		initEClass(abstractImageBarrierEClass, AbstractImageBarrier.class, "AbstractImageBarrier",
				IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAbstractImageBarrier_Transitions(), this.getImageTransition(), null,
				"transitions", null, 0, -1, AbstractImageBarrier.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);

		initEClass(referenceImageBarrierEClass, ReferenceImageBarrier.class,
				"ReferenceImageBarrier", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getReferenceImageBarrier_ImageId(), theEcorePackage.getELong(), "imageId",
				null, 0, 1, ReferenceImageBarrier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getReferenceImageBarrier_MipLevels(), theEcorePackage.getEInt(), "mipLevels",
				null, 0, 1, ReferenceImageBarrier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getReferenceImageBarrier_ImageFormat(), theEcorePackage.getEInt(),
				"imageFormat", null, 0, 1, ReferenceImageBarrier.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(imageTransitionEClass, ImageTransition.class, "ImageTransition", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getImageTransition_SrcLayout(), theEnumerationPackage.getEImageLayout(),
				"srcLayout", null, 0, 1, ImageTransition.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getImageTransition_DstLayout(), theEnumerationPackage.getEImageLayout(),
				"dstLayout", null, 0, 1, ImageTransition.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getImageTransition_SrcAccessMask(), theEnumerationPackage.getEAccess(),
				"srcAccessMask", null, 0, -1, ImageTransition.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getImageTransition_DstAccessMask(), theEnumerationPackage.getEAccess(),
				"dstAccessMask", null, 0, -1, ImageTransition.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //BarrierPackageImpl
