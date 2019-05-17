/**
 */
package org.sheepy.vulkan.model.pipeline;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

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
 * @see org.sheepy.vulkan.model.pipeline.PipelineFactory
 * @model kind="package"
 * @generated
 */
public interface PipelinePackage extends EPackage
{
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "pipeline";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "org.sheepy.vulkan.model.pipeline";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "pipeline";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	PipelinePackage eINSTANCE = org.sheepy.vulkan.model.pipeline.impl.PipelinePackageImpl.init();

	/**
	 * The meta object id for the '{@link org.sheepy.vulkan.model.pipeline.impl.PushConstantRangeImpl <em>Push Constant Range</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.vulkan.model.pipeline.impl.PushConstantRangeImpl
	 * @see org.sheepy.vulkan.model.pipeline.impl.PipelinePackageImpl#getPushConstantRange()
	 * @generated
	 */
	int PUSH_CONSTANT_RANGE = 0;

	/**
	 * The feature id for the '<em><b>Stages</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PUSH_CONSTANT_RANGE__STAGES = 0;

	/**
	 * The feature id for the '<em><b>Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PUSH_CONSTANT_RANGE__OFFSET = 1;

	/**
	 * The feature id for the '<em><b>Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PUSH_CONSTANT_RANGE__SIZE = 2;

	/**
	 * The number of structural features of the '<em>Push Constant Range</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PUSH_CONSTANT_RANGE_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Push Constant Range</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PUSH_CONSTANT_RANGE_OPERATION_COUNT = 0;

	/**
	 * Returns the meta object for class '{@link org.sheepy.vulkan.model.pipeline.PushConstantRange <em>Push Constant Range</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Push Constant Range</em>'.
	 * @see org.sheepy.vulkan.model.pipeline.PushConstantRange
	 * @generated
	 */
	EClass getPushConstantRange();

	/**
	 * Returns the meta object for the attribute list '{@link org.sheepy.vulkan.model.pipeline.PushConstantRange#getStages <em>Stages</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Stages</em>'.
	 * @see org.sheepy.vulkan.model.pipeline.PushConstantRange#getStages()
	 * @see #getPushConstantRange()
	 * @generated
	 */
	EAttribute getPushConstantRange_Stages();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.pipeline.PushConstantRange#getOffset <em>Offset</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Offset</em>'.
	 * @see org.sheepy.vulkan.model.pipeline.PushConstantRange#getOffset()
	 * @see #getPushConstantRange()
	 * @generated
	 */
	EAttribute getPushConstantRange_Offset();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.pipeline.PushConstantRange#getSize <em>Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Size</em>'.
	 * @see org.sheepy.vulkan.model.pipeline.PushConstantRange#getSize()
	 * @see #getPushConstantRange()
	 * @generated
	 */
	EAttribute getPushConstantRange_Size();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	PipelineFactory getPipelineFactory();

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
		 * The meta object literal for the '{@link org.sheepy.vulkan.model.pipeline.impl.PushConstantRangeImpl <em>Push Constant Range</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.vulkan.model.pipeline.impl.PushConstantRangeImpl
		 * @see org.sheepy.vulkan.model.pipeline.impl.PipelinePackageImpl#getPushConstantRange()
		 * @generated
		 */
		EClass PUSH_CONSTANT_RANGE = eINSTANCE.getPushConstantRange();

		/**
		 * The meta object literal for the '<em><b>Stages</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PUSH_CONSTANT_RANGE__STAGES = eINSTANCE.getPushConstantRange_Stages();

		/**
		 * The meta object literal for the '<em><b>Offset</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PUSH_CONSTANT_RANGE__OFFSET = eINSTANCE.getPushConstantRange_Offset();

		/**
		 * The meta object literal for the '<em><b>Size</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PUSH_CONSTANT_RANGE__SIZE = eINSTANCE.getPushConstantRange_Size();

	}

} //PipelinePackage
