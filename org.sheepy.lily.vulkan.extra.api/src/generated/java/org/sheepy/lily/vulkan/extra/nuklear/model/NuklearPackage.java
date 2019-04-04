/**
 */
package org.sheepy.lily.vulkan.extra.nuklear.model;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage;
import org.sheepy.lily.vulkan.model.resource.ResourcePackage;

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
 *        annotation="http://www.eclipse.org/emf/2002/GenModel modelDirectory='/org.sheepy.lily.vulkan.extra.model/src/generated/java' editDirectory='/org.sheepy.lily.vulkan.extra.model.edit/src/generated/java' modelName='Nuklear' prefix='Nuklear' publicConstructors='true' complianceLevel='11.0' resource='XMI' childCreationExtenders='true' updateClasspath='false' basePackage='org.sheepy.lily.vulkan.extra.nuklear'"
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
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.extra.nuklear.model.impl.NuklearPipelineImpl <em>Pipeline</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.extra.nuklear.model.impl.NuklearPipelineImpl
	 * @see org.sheepy.lily.vulkan.extra.nuklear.model.impl.NuklearPackageImpl#getNuklearPipeline()
	 * @generated
	 */
	int NUKLEAR_PIPELINE = 0;

	/**
	 * The feature id for the '<em><b>Content Objects</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUKLEAR_PIPELINE__CONTENT_OBJECTS = GraphicPackage.IGUI_PIPELINE__CONTENT_OBJECTS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUKLEAR_PIPELINE__NAME = GraphicPackage.IGUI_PIPELINE__NAME;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUKLEAR_PIPELINE__ENABLED = GraphicPackage.IGUI_PIPELINE__ENABLED;

	/**
	 * The feature id for the '<em><b>Stage</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUKLEAR_PIPELINE__STAGE = GraphicPackage.IGUI_PIPELINE__STAGE;

	/**
	 * The feature id for the '<em><b>Font</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUKLEAR_PIPELINE__FONT = GraphicPackage.IGUI_PIPELINE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Push Constant</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUKLEAR_PIPELINE__PUSH_CONSTANT = GraphicPackage.IGUI_PIPELINE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Subpass</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUKLEAR_PIPELINE__SUBPASS = GraphicPackage.IGUI_PIPELINE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Pipeline</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUKLEAR_PIPELINE_FEATURE_COUNT = GraphicPackage.IGUI_PIPELINE_FEATURE_COUNT + 3;

	/**
	 * The operation id for the '<em>LInference Object</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUKLEAR_PIPELINE___LINFERENCE_OBJECT = GraphicPackage.IGUI_PIPELINE___LINFERENCE_OBJECT;

	/**
	 * The operation id for the '<em>Create Containment EList</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUKLEAR_PIPELINE___CREATE_CONTAINMENT_ELIST__ECLASS = GraphicPackage.IGUI_PIPELINE___CREATE_CONTAINMENT_ELIST__ECLASS;

	/**
	 * The operation id for the '<em>LContents</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUKLEAR_PIPELINE___LCONTENTS = GraphicPackage.IGUI_PIPELINE___LCONTENTS;

	/**
	 * The operation id for the '<em>LParent</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUKLEAR_PIPELINE___LPARENT = GraphicPackage.IGUI_PIPELINE___LPARENT;

	/**
	 * The operation id for the '<em>LAll Contents</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUKLEAR_PIPELINE___LALL_CONTENTS = GraphicPackage.IGUI_PIPELINE___LALL_CONTENTS;

	/**
	 * The number of operations of the '<em>Pipeline</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUKLEAR_PIPELINE_OPERATION_COUNT = GraphicPackage.IGUI_PIPELINE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.extra.nuklear.model.impl.NuklearConstantsImpl <em>Constants</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.extra.nuklear.model.impl.NuklearConstantsImpl
	 * @see org.sheepy.lily.vulkan.extra.nuklear.model.impl.NuklearPackageImpl#getNuklearConstants()
	 * @generated
	 */
	int NUKLEAR_CONSTANTS = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUKLEAR_CONSTANTS__NAME = ResourcePackage.CONSTANTS__NAME;

	/**
	 * The feature id for the '<em><b>Stages</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUKLEAR_CONSTANTS__STAGES = ResourcePackage.CONSTANTS__STAGES;

	/**
	 * The feature id for the '<em><b>Data</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUKLEAR_CONSTANTS__DATA = ResourcePackage.CONSTANTS__DATA;

	/**
	 * The number of structural features of the '<em>Constants</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUKLEAR_CONSTANTS_FEATURE_COUNT = ResourcePackage.CONSTANTS_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Constants</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUKLEAR_CONSTANTS_OPERATION_COUNT = ResourcePackage.CONSTANTS_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.extra.nuklear.model.NuklearPipeline <em>Pipeline</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Pipeline</em>'.
	 * @see org.sheepy.lily.vulkan.extra.nuklear.model.NuklearPipeline
	 * @generated
	 */
	EClass getNuklearPipeline();

	/**
	 * Returns the meta object for the containment reference '{@link org.sheepy.lily.vulkan.extra.nuklear.model.NuklearPipeline#getFont <em>Font</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Font</em>'.
	 * @see org.sheepy.lily.vulkan.extra.nuklear.model.NuklearPipeline#getFont()
	 * @see #getNuklearPipeline()
	 * @generated
	 */
	EReference getNuklearPipeline_Font();

	/**
	 * Returns the meta object for the containment reference '{@link org.sheepy.lily.vulkan.extra.nuklear.model.NuklearPipeline#getPushConstant <em>Push Constant</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Push Constant</em>'.
	 * @see org.sheepy.lily.vulkan.extra.nuklear.model.NuklearPipeline#getPushConstant()
	 * @see #getNuklearPipeline()
	 * @generated
	 */
	EReference getNuklearPipeline_PushConstant();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.extra.nuklear.model.NuklearPipeline#getSubpass <em>Subpass</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Subpass</em>'.
	 * @see org.sheepy.lily.vulkan.extra.nuklear.model.NuklearPipeline#getSubpass()
	 * @see #getNuklearPipeline()
	 * @generated
	 */
	EAttribute getNuklearPipeline_Subpass();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.extra.nuklear.model.NuklearConstants <em>Constants</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Constants</em>'.
	 * @see org.sheepy.lily.vulkan.extra.nuklear.model.NuklearConstants
	 * @generated
	 */
	EClass getNuklearConstants();

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
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.extra.nuklear.model.impl.NuklearPipelineImpl <em>Pipeline</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.extra.nuklear.model.impl.NuklearPipelineImpl
		 * @see org.sheepy.lily.vulkan.extra.nuklear.model.impl.NuklearPackageImpl#getNuklearPipeline()
		 * @generated
		 */
		EClass NUKLEAR_PIPELINE = eINSTANCE.getNuklearPipeline();

		/**
		 * The meta object literal for the '<em><b>Font</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NUKLEAR_PIPELINE__FONT = eINSTANCE.getNuklearPipeline_Font();

		/**
		 * The meta object literal for the '<em><b>Push Constant</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NUKLEAR_PIPELINE__PUSH_CONSTANT = eINSTANCE.getNuklearPipeline_PushConstant();

		/**
		 * The meta object literal for the '<em><b>Subpass</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NUKLEAR_PIPELINE__SUBPASS = eINSTANCE.getNuklearPipeline_Subpass();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.extra.nuklear.model.impl.NuklearConstantsImpl <em>Constants</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.extra.nuklear.model.impl.NuklearConstantsImpl
		 * @see org.sheepy.lily.vulkan.extra.nuklear.model.impl.NuklearPackageImpl#getNuklearConstants()
		 * @generated
		 */
		EClass NUKLEAR_CONSTANTS = eINSTANCE.getNuklearConstants();

	}

} //NuklearPackage
