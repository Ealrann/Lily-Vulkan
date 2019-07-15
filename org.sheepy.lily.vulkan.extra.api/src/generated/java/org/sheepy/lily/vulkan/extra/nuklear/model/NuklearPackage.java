/**
 */
package org.sheepy.lily.vulkan.extra.nuklear.model;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.sheepy.lily.vulkan.model.VulkanPackage;
import org.sheepy.lily.vulkan.model.process.ProcessPackage;

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
 * @see org.sheepy.lily.vulkan.extra.nuklear.model.NuklearFactory
 * @model kind="package"
 * @generated
 */
public interface NuklearPackage extends EPackage
{
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "model";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "org.sheepy.lily.vulkan.extra.nuklear.model";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "model";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	NuklearPackage eINSTANCE = org.sheepy.lily.vulkan.extra.nuklear.model.impl.NuklearPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.extra.nuklear.model.impl.NuklearPushConstantsImpl <em>Push Constants</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.extra.nuklear.model.impl.NuklearPushConstantsImpl
	 * @see org.sheepy.lily.vulkan.extra.nuklear.model.impl.NuklearPackageImpl#getNuklearPushConstants()
	 * @generated
	 */
	int NUKLEAR_PUSH_CONSTANTS = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUKLEAR_PUSH_CONSTANTS__NAME = ProcessPackage.PUSH_CONSTANT__NAME;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUKLEAR_PUSH_CONSTANTS__ENABLED = ProcessPackage.PUSH_CONSTANT__ENABLED;

	/**
	 * The feature id for the '<em><b>Stages</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUKLEAR_PUSH_CONSTANTS__STAGES = ProcessPackage.PUSH_CONSTANT__STAGES;

	/**
	 * The feature id for the '<em><b>Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUKLEAR_PUSH_CONSTANTS__WIDTH = ProcessPackage.PUSH_CONSTANT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUKLEAR_PUSH_CONSTANTS__HEIGHT = ProcessPackage.PUSH_CONSTANT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Current Descriptor</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUKLEAR_PUSH_CONSTANTS__CURRENT_DESCRIPTOR = ProcessPackage.PUSH_CONSTANT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Push Constants</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUKLEAR_PUSH_CONSTANTS_FEATURE_COUNT = ProcessPackage.PUSH_CONSTANT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.extra.nuklear.model.impl.NuklearLayoutTaskImpl <em>Layout Task</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.extra.nuklear.model.impl.NuklearLayoutTaskImpl
	 * @see org.sheepy.lily.vulkan.extra.nuklear.model.impl.NuklearPackageImpl#getNuklearLayoutTask()
	 * @generated
	 */
	int NUKLEAR_LAYOUT_TASK = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUKLEAR_LAYOUT_TASK__NAME = ProcessPackage.IPIPELINE_TASK__NAME;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUKLEAR_LAYOUT_TASK__ENABLED = ProcessPackage.IPIPELINE_TASK__ENABLED;

	/**
	 * The feature id for the '<em><b>Context</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUKLEAR_LAYOUT_TASK__CONTEXT = ProcessPackage.IPIPELINE_TASK_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Draw Task</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUKLEAR_LAYOUT_TASK__DRAW_TASK = ProcessPackage.IPIPELINE_TASK_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Push Buffer</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUKLEAR_LAYOUT_TASK__PUSH_BUFFER = ProcessPackage.IPIPELINE_TASK_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Vertex Buffer</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUKLEAR_LAYOUT_TASK__VERTEX_BUFFER = ProcessPackage.IPIPELINE_TASK_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Layout Task</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUKLEAR_LAYOUT_TASK_FEATURE_COUNT = ProcessPackage.IPIPELINE_TASK_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.extra.nuklear.model.impl.NuklearContextImpl <em>Context</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.extra.nuklear.model.impl.NuklearContextImpl
	 * @see org.sheepy.lily.vulkan.extra.nuklear.model.impl.NuklearPackageImpl#getNuklearContext()
	 * @generated
	 */
	int NUKLEAR_CONTEXT = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUKLEAR_CONTEXT__NAME = VulkanPackage.IRESOURCE__NAME;

	/**
	 * The feature id for the '<em><b>Font</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUKLEAR_CONTEXT__FONT = VulkanPackage.IRESOURCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Null Texture</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUKLEAR_CONTEXT__NULL_TEXTURE = VulkanPackage.IRESOURCE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Layout Task</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUKLEAR_CONTEXT__LAYOUT_TASK = VulkanPackage.IRESOURCE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Context</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUKLEAR_CONTEXT_FEATURE_COUNT = VulkanPackage.IRESOURCE_FEATURE_COUNT + 3;

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.extra.nuklear.model.NuklearPushConstants <em>Push Constants</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Push Constants</em>'.
	 * @see org.sheepy.lily.vulkan.extra.nuklear.model.NuklearPushConstants
	 * @generated
	 */
	EClass getNuklearPushConstants();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.extra.nuklear.model.NuklearPushConstants#getWidth <em>Width</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Width</em>'.
	 * @see org.sheepy.lily.vulkan.extra.nuklear.model.NuklearPushConstants#getWidth()
	 * @see #getNuklearPushConstants()
	 * @generated
	 */
	EAttribute getNuklearPushConstants_Width();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.extra.nuklear.model.NuklearPushConstants#getHeight <em>Height</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Height</em>'.
	 * @see org.sheepy.lily.vulkan.extra.nuklear.model.NuklearPushConstants#getHeight()
	 * @see #getNuklearPushConstants()
	 * @generated
	 */
	EAttribute getNuklearPushConstants_Height();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.extra.nuklear.model.NuklearPushConstants#getCurrentDescriptor <em>Current Descriptor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Current Descriptor</em>'.
	 * @see org.sheepy.lily.vulkan.extra.nuklear.model.NuklearPushConstants#getCurrentDescriptor()
	 * @see #getNuklearPushConstants()
	 * @generated
	 */
	EAttribute getNuklearPushConstants_CurrentDescriptor();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.extra.nuklear.model.NuklearLayoutTask <em>Layout Task</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Layout Task</em>'.
	 * @see org.sheepy.lily.vulkan.extra.nuklear.model.NuklearLayoutTask
	 * @generated
	 */
	EClass getNuklearLayoutTask();

	/**
	 * Returns the meta object for the reference '{@link org.sheepy.lily.vulkan.extra.nuklear.model.NuklearLayoutTask#getContext <em>Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Context</em>'.
	 * @see org.sheepy.lily.vulkan.extra.nuklear.model.NuklearLayoutTask#getContext()
	 * @see #getNuklearLayoutTask()
	 * @generated
	 */
	EReference getNuklearLayoutTask_Context();

	/**
	 * Returns the meta object for the reference '{@link org.sheepy.lily.vulkan.extra.nuklear.model.NuklearLayoutTask#getDrawTask <em>Draw Task</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Draw Task</em>'.
	 * @see org.sheepy.lily.vulkan.extra.nuklear.model.NuklearLayoutTask#getDrawTask()
	 * @see #getNuklearLayoutTask()
	 * @generated
	 */
	EReference getNuklearLayoutTask_DrawTask();

	/**
	 * Returns the meta object for the reference '{@link org.sheepy.lily.vulkan.extra.nuklear.model.NuklearLayoutTask#getPushBuffer <em>Push Buffer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Push Buffer</em>'.
	 * @see org.sheepy.lily.vulkan.extra.nuklear.model.NuklearLayoutTask#getPushBuffer()
	 * @see #getNuklearLayoutTask()
	 * @generated
	 */
	EReference getNuklearLayoutTask_PushBuffer();

	/**
	 * Returns the meta object for the reference '{@link org.sheepy.lily.vulkan.extra.nuklear.model.NuklearLayoutTask#getVertexBuffer <em>Vertex Buffer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Vertex Buffer</em>'.
	 * @see org.sheepy.lily.vulkan.extra.nuklear.model.NuklearLayoutTask#getVertexBuffer()
	 * @see #getNuklearLayoutTask()
	 * @generated
	 */
	EReference getNuklearLayoutTask_VertexBuffer();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.extra.nuklear.model.NuklearContext <em>Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Context</em>'.
	 * @see org.sheepy.lily.vulkan.extra.nuklear.model.NuklearContext
	 * @generated
	 */
	EClass getNuklearContext();

	/**
	 * Returns the meta object for the reference '{@link org.sheepy.lily.vulkan.extra.nuklear.model.NuklearContext#getFont <em>Font</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Font</em>'.
	 * @see org.sheepy.lily.vulkan.extra.nuklear.model.NuklearContext#getFont()
	 * @see #getNuklearContext()
	 * @generated
	 */
	EReference getNuklearContext_Font();

	/**
	 * Returns the meta object for the reference '{@link org.sheepy.lily.vulkan.extra.nuklear.model.NuklearContext#getNullTexture <em>Null Texture</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Null Texture</em>'.
	 * @see org.sheepy.lily.vulkan.extra.nuklear.model.NuklearContext#getNullTexture()
	 * @see #getNuklearContext()
	 * @generated
	 */
	EReference getNuklearContext_NullTexture();

	/**
	 * Returns the meta object for the reference '{@link org.sheepy.lily.vulkan.extra.nuklear.model.NuklearContext#getLayoutTask <em>Layout Task</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Layout Task</em>'.
	 * @see org.sheepy.lily.vulkan.extra.nuklear.model.NuklearContext#getLayoutTask()
	 * @see #getNuklearContext()
	 * @generated
	 */
	EReference getNuklearContext_LayoutTask();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	NuklearFactory getNuklearFactory();

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
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.extra.nuklear.model.impl.NuklearPushConstantsImpl <em>Push Constants</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.extra.nuklear.model.impl.NuklearPushConstantsImpl
		 * @see org.sheepy.lily.vulkan.extra.nuklear.model.impl.NuklearPackageImpl#getNuklearPushConstants()
		 * @generated
		 */
		EClass NUKLEAR_PUSH_CONSTANTS = eINSTANCE.getNuklearPushConstants();

		/**
		 * The meta object literal for the '<em><b>Width</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NUKLEAR_PUSH_CONSTANTS__WIDTH = eINSTANCE.getNuklearPushConstants_Width();

		/**
		 * The meta object literal for the '<em><b>Height</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NUKLEAR_PUSH_CONSTANTS__HEIGHT = eINSTANCE.getNuklearPushConstants_Height();

		/**
		 * The meta object literal for the '<em><b>Current Descriptor</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NUKLEAR_PUSH_CONSTANTS__CURRENT_DESCRIPTOR = eINSTANCE.getNuklearPushConstants_CurrentDescriptor();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.extra.nuklear.model.impl.NuklearLayoutTaskImpl <em>Layout Task</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.extra.nuklear.model.impl.NuklearLayoutTaskImpl
		 * @see org.sheepy.lily.vulkan.extra.nuklear.model.impl.NuklearPackageImpl#getNuklearLayoutTask()
		 * @generated
		 */
		EClass NUKLEAR_LAYOUT_TASK = eINSTANCE.getNuklearLayoutTask();

		/**
		 * The meta object literal for the '<em><b>Context</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NUKLEAR_LAYOUT_TASK__CONTEXT = eINSTANCE.getNuklearLayoutTask_Context();

		/**
		 * The meta object literal for the '<em><b>Draw Task</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NUKLEAR_LAYOUT_TASK__DRAW_TASK = eINSTANCE.getNuklearLayoutTask_DrawTask();

		/**
		 * The meta object literal for the '<em><b>Push Buffer</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NUKLEAR_LAYOUT_TASK__PUSH_BUFFER = eINSTANCE.getNuklearLayoutTask_PushBuffer();

		/**
		 * The meta object literal for the '<em><b>Vertex Buffer</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NUKLEAR_LAYOUT_TASK__VERTEX_BUFFER = eINSTANCE.getNuklearLayoutTask_VertexBuffer();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.extra.nuklear.model.impl.NuklearContextImpl <em>Context</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.extra.nuklear.model.impl.NuklearContextImpl
		 * @see org.sheepy.lily.vulkan.extra.nuklear.model.impl.NuklearPackageImpl#getNuklearContext()
		 * @generated
		 */
		EClass NUKLEAR_CONTEXT = eINSTANCE.getNuklearContext();

		/**
		 * The meta object literal for the '<em><b>Font</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NUKLEAR_CONTEXT__FONT = eINSTANCE.getNuklearContext_Font();

		/**
		 * The meta object literal for the '<em><b>Null Texture</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NUKLEAR_CONTEXT__NULL_TEXTURE = eINSTANCE.getNuklearContext_NullTexture();

		/**
		 * The meta object literal for the '<em><b>Layout Task</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NUKLEAR_CONTEXT__LAYOUT_TASK = eINSTANCE.getNuklearContext_LayoutTask();

	}

} //NuklearPackage
