/**
 */
package org.sheepy.vulkan.model.barrier;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.sheepy.vulkan.model.barrier.BarrierFactory
 * @model kind="package"
 * @generated
 */
public interface BarrierPackage extends EPackage
{
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "barrier";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "org.sheepy.vulkan.model.barrier";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "barrier";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	BarrierPackage eINSTANCE = org.sheepy.vulkan.model.barrier.impl.BarrierPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.sheepy.vulkan.model.barrier.impl.BarrierImpl <em>Barrier</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.vulkan.model.barrier.impl.BarrierImpl
	 * @see org.sheepy.vulkan.model.barrier.impl.BarrierPackageImpl#getBarrier()
	 * @generated
	 */
	int BARRIER = 0;

	/**
	 * The feature id for the '<em><b>Src Stage</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BARRIER__SRC_STAGE = 0;

	/**
	 * The feature id for the '<em><b>Dst Stage</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BARRIER__DST_STAGE = 1;

	/**
	 * The number of structural features of the '<em>Barrier</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BARRIER_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Barrier</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BARRIER_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.sheepy.vulkan.model.barrier.impl.AbstractBufferBarrierImpl <em>Abstract Buffer Barrier</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.vulkan.model.barrier.impl.AbstractBufferBarrierImpl
	 * @see org.sheepy.vulkan.model.barrier.impl.BarrierPackageImpl#getAbstractBufferBarrier()
	 * @generated
	 */
	int ABSTRACT_BUFFER_BARRIER = 1;

	/**
	 * The feature id for the '<em><b>Src Stage</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_BUFFER_BARRIER__SRC_STAGE = BARRIER__SRC_STAGE;

	/**
	 * The feature id for the '<em><b>Dst Stage</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_BUFFER_BARRIER__DST_STAGE = BARRIER__DST_STAGE;

	/**
	 * The feature id for the '<em><b>Src Access</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_BUFFER_BARRIER__SRC_ACCESS = BARRIER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Dst Access</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_BUFFER_BARRIER__DST_ACCESS = BARRIER_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Abstract Buffer Barrier</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_BUFFER_BARRIER_FEATURE_COUNT = BARRIER_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Abstract Buffer Barrier</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_BUFFER_BARRIER_OPERATION_COUNT = BARRIER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.vulkan.model.barrier.impl.AbstractImageBarrierImpl <em>Abstract Image Barrier</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.vulkan.model.barrier.impl.AbstractImageBarrierImpl
	 * @see org.sheepy.vulkan.model.barrier.impl.BarrierPackageImpl#getAbstractImageBarrier()
	 * @generated
	 */
	int ABSTRACT_IMAGE_BARRIER = 3;

	/**
	 * The meta object id for the '{@link org.sheepy.vulkan.model.barrier.impl.ReferenceBufferBarrierImpl <em>Reference Buffer Barrier</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.vulkan.model.barrier.impl.ReferenceBufferBarrierImpl
	 * @see org.sheepy.vulkan.model.barrier.impl.BarrierPackageImpl#getReferenceBufferBarrier()
	 * @generated
	 */
	int REFERENCE_BUFFER_BARRIER = 2;

	/**
	 * The feature id for the '<em><b>Src Stage</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_BUFFER_BARRIER__SRC_STAGE = ABSTRACT_BUFFER_BARRIER__SRC_STAGE;

	/**
	 * The feature id for the '<em><b>Dst Stage</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_BUFFER_BARRIER__DST_STAGE = ABSTRACT_BUFFER_BARRIER__DST_STAGE;

	/**
	 * The feature id for the '<em><b>Src Access</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_BUFFER_BARRIER__SRC_ACCESS = ABSTRACT_BUFFER_BARRIER__SRC_ACCESS;

	/**
	 * The feature id for the '<em><b>Dst Access</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_BUFFER_BARRIER__DST_ACCESS = ABSTRACT_BUFFER_BARRIER__DST_ACCESS;

	/**
	 * The feature id for the '<em><b>Buffer Address</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_BUFFER_BARRIER__BUFFER_ADDRESS = ABSTRACT_BUFFER_BARRIER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Reference Buffer Barrier</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_BUFFER_BARRIER_FEATURE_COUNT = ABSTRACT_BUFFER_BARRIER_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Reference Buffer Barrier</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_BUFFER_BARRIER_OPERATION_COUNT = ABSTRACT_BUFFER_BARRIER_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Src Stage</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_IMAGE_BARRIER__SRC_STAGE = BARRIER__SRC_STAGE;

	/**
	 * The feature id for the '<em><b>Dst Stage</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_IMAGE_BARRIER__DST_STAGE = BARRIER__DST_STAGE;

	/**
	 * The feature id for the '<em><b>Transitions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_IMAGE_BARRIER__TRANSITIONS = BARRIER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Abstract Image Barrier</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_IMAGE_BARRIER_FEATURE_COUNT = BARRIER_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Abstract Image Barrier</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_IMAGE_BARRIER_OPERATION_COUNT = BARRIER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.vulkan.model.barrier.impl.ReferenceImageBarrierImpl <em>Reference Image Barrier</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.vulkan.model.barrier.impl.ReferenceImageBarrierImpl
	 * @see org.sheepy.vulkan.model.barrier.impl.BarrierPackageImpl#getReferenceImageBarrier()
	 * @generated
	 */
	int REFERENCE_IMAGE_BARRIER = 4;

	/**
	 * The feature id for the '<em><b>Src Stage</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_IMAGE_BARRIER__SRC_STAGE = ABSTRACT_IMAGE_BARRIER__SRC_STAGE;

	/**
	 * The feature id for the '<em><b>Dst Stage</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_IMAGE_BARRIER__DST_STAGE = ABSTRACT_IMAGE_BARRIER__DST_STAGE;

	/**
	 * The feature id for the '<em><b>Transitions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_IMAGE_BARRIER__TRANSITIONS = ABSTRACT_IMAGE_BARRIER__TRANSITIONS;

	/**
	 * The feature id for the '<em><b>Image Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_IMAGE_BARRIER__IMAGE_ID = ABSTRACT_IMAGE_BARRIER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Mip Levels</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_IMAGE_BARRIER__MIP_LEVELS = ABSTRACT_IMAGE_BARRIER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Image Format</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_IMAGE_BARRIER__IMAGE_FORMAT = ABSTRACT_IMAGE_BARRIER_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Reference Image Barrier</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_IMAGE_BARRIER_FEATURE_COUNT = ABSTRACT_IMAGE_BARRIER_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Reference Image Barrier</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_IMAGE_BARRIER_OPERATION_COUNT = ABSTRACT_IMAGE_BARRIER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.vulkan.model.barrier.impl.ImageTransitionImpl <em>Image Transition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.vulkan.model.barrier.impl.ImageTransitionImpl
	 * @see org.sheepy.vulkan.model.barrier.impl.BarrierPackageImpl#getImageTransition()
	 * @generated
	 */
	int IMAGE_TRANSITION = 5;

	/**
	 * The feature id for the '<em><b>Src Layout</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_TRANSITION__SRC_LAYOUT = 0;

	/**
	 * The feature id for the '<em><b>Dst Layout</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_TRANSITION__DST_LAYOUT = 1;

	/**
	 * The feature id for the '<em><b>Src Access Mask</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_TRANSITION__SRC_ACCESS_MASK = 2;

	/**
	 * The feature id for the '<em><b>Dst Access Mask</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_TRANSITION__DST_ACCESS_MASK = 3;

	/**
	 * The number of structural features of the '<em>Image Transition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_TRANSITION_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Image Transition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_TRANSITION_OPERATION_COUNT = 0;

	/**
	 * Returns the meta object for class '{@link org.sheepy.vulkan.model.barrier.Barrier <em>Barrier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Barrier</em>'.
	 * @see org.sheepy.vulkan.model.barrier.Barrier
	 * @generated
	 */
	EClass getBarrier();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.barrier.Barrier#getSrcStage <em>Src Stage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Src Stage</em>'.
	 * @see org.sheepy.vulkan.model.barrier.Barrier#getSrcStage()
	 * @see #getBarrier()
	 * @generated
	 */
	EAttribute getBarrier_SrcStage();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.barrier.Barrier#getDstStage <em>Dst Stage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Dst Stage</em>'.
	 * @see org.sheepy.vulkan.model.barrier.Barrier#getDstStage()
	 * @see #getBarrier()
	 * @generated
	 */
	EAttribute getBarrier_DstStage();

	/**
	 * Returns the meta object for class '{@link org.sheepy.vulkan.model.barrier.AbstractBufferBarrier <em>Abstract Buffer Barrier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract Buffer Barrier</em>'.
	 * @see org.sheepy.vulkan.model.barrier.AbstractBufferBarrier
	 * @generated
	 */
	EClass getAbstractBufferBarrier();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.barrier.AbstractBufferBarrier#getSrcAccess <em>Src Access</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Src Access</em>'.
	 * @see org.sheepy.vulkan.model.barrier.AbstractBufferBarrier#getSrcAccess()
	 * @see #getAbstractBufferBarrier()
	 * @generated
	 */
	EAttribute getAbstractBufferBarrier_SrcAccess();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.barrier.AbstractBufferBarrier#getDstAccess <em>Dst Access</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Dst Access</em>'.
	 * @see org.sheepy.vulkan.model.barrier.AbstractBufferBarrier#getDstAccess()
	 * @see #getAbstractBufferBarrier()
	 * @generated
	 */
	EAttribute getAbstractBufferBarrier_DstAccess();

	/**
	 * Returns the meta object for class '{@link org.sheepy.vulkan.model.barrier.ReferenceBufferBarrier <em>Reference Buffer Barrier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Reference Buffer Barrier</em>'.
	 * @see org.sheepy.vulkan.model.barrier.ReferenceBufferBarrier
	 * @generated
	 */
	EClass getReferenceBufferBarrier();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.barrier.ReferenceBufferBarrier#getBufferAddress <em>Buffer Address</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Buffer Address</em>'.
	 * @see org.sheepy.vulkan.model.barrier.ReferenceBufferBarrier#getBufferAddress()
	 * @see #getReferenceBufferBarrier()
	 * @generated
	 */
	EAttribute getReferenceBufferBarrier_BufferAddress();

	/**
	 * Returns the meta object for class '{@link org.sheepy.vulkan.model.barrier.AbstractImageBarrier <em>Abstract Image Barrier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract Image Barrier</em>'.
	 * @see org.sheepy.vulkan.model.barrier.AbstractImageBarrier
	 * @generated
	 */
	EClass getAbstractImageBarrier();

	/**
	 * Returns the meta object for the containment reference list '{@link org.sheepy.vulkan.model.barrier.AbstractImageBarrier#getTransitions <em>Transitions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Transitions</em>'.
	 * @see org.sheepy.vulkan.model.barrier.AbstractImageBarrier#getTransitions()
	 * @see #getAbstractImageBarrier()
	 * @generated
	 */
	EReference getAbstractImageBarrier_Transitions();

	/**
	 * Returns the meta object for class '{@link org.sheepy.vulkan.model.barrier.ReferenceImageBarrier <em>Reference Image Barrier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Reference Image Barrier</em>'.
	 * @see org.sheepy.vulkan.model.barrier.ReferenceImageBarrier
	 * @generated
	 */
	EClass getReferenceImageBarrier();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.barrier.ReferenceImageBarrier#getImageId <em>Image Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Image Id</em>'.
	 * @see org.sheepy.vulkan.model.barrier.ReferenceImageBarrier#getImageId()
	 * @see #getReferenceImageBarrier()
	 * @generated
	 */
	EAttribute getReferenceImageBarrier_ImageId();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.barrier.ReferenceImageBarrier#getMipLevels <em>Mip Levels</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Mip Levels</em>'.
	 * @see org.sheepy.vulkan.model.barrier.ReferenceImageBarrier#getMipLevels()
	 * @see #getReferenceImageBarrier()
	 * @generated
	 */
	EAttribute getReferenceImageBarrier_MipLevels();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.barrier.ReferenceImageBarrier#getImageFormat <em>Image Format</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Image Format</em>'.
	 * @see org.sheepy.vulkan.model.barrier.ReferenceImageBarrier#getImageFormat()
	 * @see #getReferenceImageBarrier()
	 * @generated
	 */
	EAttribute getReferenceImageBarrier_ImageFormat();

	/**
	 * Returns the meta object for class '{@link org.sheepy.vulkan.model.barrier.ImageTransition <em>Image Transition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Image Transition</em>'.
	 * @see org.sheepy.vulkan.model.barrier.ImageTransition
	 * @generated
	 */
	EClass getImageTransition();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.barrier.ImageTransition#getSrcLayout <em>Src Layout</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Src Layout</em>'.
	 * @see org.sheepy.vulkan.model.barrier.ImageTransition#getSrcLayout()
	 * @see #getImageTransition()
	 * @generated
	 */
	EAttribute getImageTransition_SrcLayout();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.barrier.ImageTransition#getDstLayout <em>Dst Layout</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Dst Layout</em>'.
	 * @see org.sheepy.vulkan.model.barrier.ImageTransition#getDstLayout()
	 * @see #getImageTransition()
	 * @generated
	 */
	EAttribute getImageTransition_DstLayout();

	/**
	 * Returns the meta object for the attribute list '{@link org.sheepy.vulkan.model.barrier.ImageTransition#getSrcAccessMask <em>Src Access Mask</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Src Access Mask</em>'.
	 * @see org.sheepy.vulkan.model.barrier.ImageTransition#getSrcAccessMask()
	 * @see #getImageTransition()
	 * @generated
	 */
	EAttribute getImageTransition_SrcAccessMask();

	/**
	 * Returns the meta object for the attribute list '{@link org.sheepy.vulkan.model.barrier.ImageTransition#getDstAccessMask <em>Dst Access Mask</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Dst Access Mask</em>'.
	 * @see org.sheepy.vulkan.model.barrier.ImageTransition#getDstAccessMask()
	 * @see #getImageTransition()
	 * @generated
	 */
	EAttribute getImageTransition_DstAccessMask();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	BarrierFactory getBarrierFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals
	{
		/**
		 * The meta object literal for the '{@link org.sheepy.vulkan.model.barrier.impl.BarrierImpl <em>Barrier</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.vulkan.model.barrier.impl.BarrierImpl
		 * @see org.sheepy.vulkan.model.barrier.impl.BarrierPackageImpl#getBarrier()
		 * @generated
		 */
		EClass BARRIER = eINSTANCE.getBarrier();

		/**
		 * The meta object literal for the '<em><b>Src Stage</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BARRIER__SRC_STAGE = eINSTANCE.getBarrier_SrcStage();

		/**
		 * The meta object literal for the '<em><b>Dst Stage</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BARRIER__DST_STAGE = eINSTANCE.getBarrier_DstStage();

		/**
		 * The meta object literal for the '{@link org.sheepy.vulkan.model.barrier.impl.AbstractBufferBarrierImpl <em>Abstract Buffer Barrier</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.vulkan.model.barrier.impl.AbstractBufferBarrierImpl
		 * @see org.sheepy.vulkan.model.barrier.impl.BarrierPackageImpl#getAbstractBufferBarrier()
		 * @generated
		 */
		EClass ABSTRACT_BUFFER_BARRIER = eINSTANCE.getAbstractBufferBarrier();

		/**
		 * The meta object literal for the '<em><b>Src Access</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ABSTRACT_BUFFER_BARRIER__SRC_ACCESS = eINSTANCE
				.getAbstractBufferBarrier_SrcAccess();

		/**
		 * The meta object literal for the '<em><b>Dst Access</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ABSTRACT_BUFFER_BARRIER__DST_ACCESS = eINSTANCE
				.getAbstractBufferBarrier_DstAccess();

		/**
		 * The meta object literal for the '{@link org.sheepy.vulkan.model.barrier.impl.ReferenceBufferBarrierImpl <em>Reference Buffer Barrier</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.vulkan.model.barrier.impl.ReferenceBufferBarrierImpl
		 * @see org.sheepy.vulkan.model.barrier.impl.BarrierPackageImpl#getReferenceBufferBarrier()
		 * @generated
		 */
		EClass REFERENCE_BUFFER_BARRIER = eINSTANCE.getReferenceBufferBarrier();

		/**
		 * The meta object literal for the '<em><b>Buffer Address</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REFERENCE_BUFFER_BARRIER__BUFFER_ADDRESS = eINSTANCE
				.getReferenceBufferBarrier_BufferAddress();

		/**
		 * The meta object literal for the '{@link org.sheepy.vulkan.model.barrier.impl.AbstractImageBarrierImpl <em>Abstract Image Barrier</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.vulkan.model.barrier.impl.AbstractImageBarrierImpl
		 * @see org.sheepy.vulkan.model.barrier.impl.BarrierPackageImpl#getAbstractImageBarrier()
		 * @generated
		 */
		EClass ABSTRACT_IMAGE_BARRIER = eINSTANCE.getAbstractImageBarrier();

		/**
		 * The meta object literal for the '<em><b>Transitions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_IMAGE_BARRIER__TRANSITIONS = eINSTANCE
				.getAbstractImageBarrier_Transitions();

		/**
		 * The meta object literal for the '{@link org.sheepy.vulkan.model.barrier.impl.ReferenceImageBarrierImpl <em>Reference Image Barrier</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.vulkan.model.barrier.impl.ReferenceImageBarrierImpl
		 * @see org.sheepy.vulkan.model.barrier.impl.BarrierPackageImpl#getReferenceImageBarrier()
		 * @generated
		 */
		EClass REFERENCE_IMAGE_BARRIER = eINSTANCE.getReferenceImageBarrier();

		/**
		 * The meta object literal for the '<em><b>Image Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REFERENCE_IMAGE_BARRIER__IMAGE_ID = eINSTANCE.getReferenceImageBarrier_ImageId();

		/**
		 * The meta object literal for the '<em><b>Mip Levels</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REFERENCE_IMAGE_BARRIER__MIP_LEVELS = eINSTANCE
				.getReferenceImageBarrier_MipLevels();

		/**
		 * The meta object literal for the '<em><b>Image Format</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REFERENCE_IMAGE_BARRIER__IMAGE_FORMAT = eINSTANCE
				.getReferenceImageBarrier_ImageFormat();

		/**
		 * The meta object literal for the '{@link org.sheepy.vulkan.model.barrier.impl.ImageTransitionImpl <em>Image Transition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.vulkan.model.barrier.impl.ImageTransitionImpl
		 * @see org.sheepy.vulkan.model.barrier.impl.BarrierPackageImpl#getImageTransition()
		 * @generated
		 */
		EClass IMAGE_TRANSITION = eINSTANCE.getImageTransition();

		/**
		 * The meta object literal for the '<em><b>Src Layout</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IMAGE_TRANSITION__SRC_LAYOUT = eINSTANCE.getImageTransition_SrcLayout();

		/**
		 * The meta object literal for the '<em><b>Dst Layout</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IMAGE_TRANSITION__DST_LAYOUT = eINSTANCE.getImageTransition_DstLayout();

		/**
		 * The meta object literal for the '<em><b>Src Access Mask</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IMAGE_TRANSITION__SRC_ACCESS_MASK = eINSTANCE.getImageTransition_SrcAccessMask();

		/**
		 * The meta object literal for the '<em><b>Dst Access Mask</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IMAGE_TRANSITION__DST_ACCESS_MASK = eINSTANCE.getImageTransition_DstAccessMask();

	}

} //BarrierPackage
