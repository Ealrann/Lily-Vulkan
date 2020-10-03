/**
 */
package org.sheepy.lily.vulkan.extra.model.sprite;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.EReference;
import org.sheepy.lily.vulkan.model.process.ProcessPackage;
import org.sheepy.lily.vulkan.model.vulkanresource.VulkanResourcePackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.sheepy.lily.vulkan.extra.model.sprite.SpriteFactory
 * @model kind="package"
 * @generated
 */
public interface SpritePackage extends EPackage
{
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "sprite";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "org.sheepy.lily.vulkan.extra.model.sprite";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "sprite";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SpritePackage eINSTANCE = org.sheepy.lily.vulkan.extra.model.sprite.impl.SpritePackageImpl.init();

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.extra.model.sprite.impl.SpriteExtensionImpl <em>Extension</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.extra.model.sprite.impl.SpriteExtensionImpl
	 * @see org.sheepy.lily.vulkan.extra.model.sprite.impl.SpritePackageImpl#getSpriteExtension()
	 * @generated
	 */
	int SPRITE_EXTENSION = 0;

	/**
	 * The feature id for the '<em><b>Draw Task</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPRITE_EXTENSION__DRAW_TASK = ProcessPackage.IPIPELINE_EXTENSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Index Buffer Viewer</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPRITE_EXTENSION__INDEX_BUFFER_VIEWER = ProcessPackage.IPIPELINE_EXTENSION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Vertex Buffer Viewer</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPRITE_EXTENSION__VERTEX_BUFFER_VIEWER = ProcessPackage.IPIPELINE_EXTENSION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Sprites Descriptor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPRITE_EXTENSION__SPRITES_DESCRIPTOR = ProcessPackage.IPIPELINE_EXTENSION_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Sprite Data Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPRITE_EXTENSION__SPRITE_DATA_SOURCE = ProcessPackage.IPIPELINE_EXTENSION_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Sprite Pipeline Specialization</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPRITE_EXTENSION__SPRITE_PIPELINE_SPECIALIZATION = ProcessPackage.IPIPELINE_EXTENSION_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Sprite Image Memory</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPRITE_EXTENSION__SPRITE_IMAGE_MEMORY = ProcessPackage.IPIPELINE_EXTENSION_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>Extension</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPRITE_EXTENSION_FEATURE_COUNT = ProcessPackage.IPIPELINE_EXTENSION_FEATURE_COUNT + 7;

	/**
	 * The number of operations of the '<em>Extension</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPRITE_EXTENSION_OPERATION_COUNT = ProcessPackage.IPIPELINE_EXTENSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.extra.model.sprite.ISpriteDataSource <em>ISprite Data Source</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.extra.model.sprite.ISpriteDataSource
	 * @see org.sheepy.lily.vulkan.extra.model.sprite.impl.SpritePackageImpl#getISpriteDataSource()
	 * @generated
	 */
	int ISPRITE_DATA_SOURCE = 1;

	/**
	 * The number of structural features of the '<em>ISprite Data Source</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISPRITE_DATA_SOURCE_FEATURE_COUNT = VulkanResourcePackage.IBUFFER_DATA_SOURCE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>ISprite Data Source</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISPRITE_DATA_SOURCE_OPERATION_COUNT = VulkanResourcePackage.IBUFFER_DATA_SOURCE_OPERATION_COUNT + 0;

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.extra.model.sprite.SpriteExtension <em>Extension</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Extension</em>'.
	 * @see org.sheepy.lily.vulkan.extra.model.sprite.SpriteExtension
	 * @generated
	 */
	EClass getSpriteExtension();

	/**
	 * Returns the meta object for the reference '{@link org.sheepy.lily.vulkan.extra.model.sprite.SpriteExtension#getDrawTask <em>Draw Task</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Draw Task</em>'.
	 * @see org.sheepy.lily.vulkan.extra.model.sprite.SpriteExtension#getDrawTask()
	 * @see #getSpriteExtension()
	 * @generated
	 */
	EReference getSpriteExtension_DrawTask();

	/**
	 * Returns the meta object for the reference '{@link org.sheepy.lily.vulkan.extra.model.sprite.SpriteExtension#getIndexBufferViewer <em>Index Buffer Viewer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Index Buffer Viewer</em>'.
	 * @see org.sheepy.lily.vulkan.extra.model.sprite.SpriteExtension#getIndexBufferViewer()
	 * @see #getSpriteExtension()
	 * @generated
	 */
	EReference getSpriteExtension_IndexBufferViewer();

	/**
	 * Returns the meta object for the reference '{@link org.sheepy.lily.vulkan.extra.model.sprite.SpriteExtension#getVertexBufferViewer <em>Vertex Buffer Viewer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Vertex Buffer Viewer</em>'.
	 * @see org.sheepy.lily.vulkan.extra.model.sprite.SpriteExtension#getVertexBufferViewer()
	 * @see #getSpriteExtension()
	 * @generated
	 */
	EReference getSpriteExtension_VertexBufferViewer();

	/**
	 * Returns the meta object for the reference '{@link org.sheepy.lily.vulkan.extra.model.sprite.SpriteExtension#getSpritesDescriptor <em>Sprites Descriptor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Sprites Descriptor</em>'.
	 * @see org.sheepy.lily.vulkan.extra.model.sprite.SpriteExtension#getSpritesDescriptor()
	 * @see #getSpriteExtension()
	 * @generated
	 */
	EReference getSpriteExtension_SpritesDescriptor();

	/**
	 * Returns the meta object for the reference '{@link org.sheepy.lily.vulkan.extra.model.sprite.SpriteExtension#getSpriteDataSource <em>Sprite Data Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Sprite Data Source</em>'.
	 * @see org.sheepy.lily.vulkan.extra.model.sprite.SpriteExtension#getSpriteDataSource()
	 * @see #getSpriteExtension()
	 * @generated
	 */
	EReference getSpriteExtension_SpriteDataSource();

	/**
	 * Returns the meta object for the reference '{@link org.sheepy.lily.vulkan.extra.model.sprite.SpriteExtension#getSpritePipelineSpecialization <em>Sprite Pipeline Specialization</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Sprite Pipeline Specialization</em>'.
	 * @see org.sheepy.lily.vulkan.extra.model.sprite.SpriteExtension#getSpritePipelineSpecialization()
	 * @see #getSpriteExtension()
	 * @generated
	 */
	EReference getSpriteExtension_SpritePipelineSpecialization();

	/**
	 * Returns the meta object for the reference '{@link org.sheepy.lily.vulkan.extra.model.sprite.SpriteExtension#getSpriteImageMemory <em>Sprite Image Memory</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Sprite Image Memory</em>'.
	 * @see org.sheepy.lily.vulkan.extra.model.sprite.SpriteExtension#getSpriteImageMemory()
	 * @see #getSpriteExtension()
	 * @generated
	 */
	EReference getSpriteExtension_SpriteImageMemory();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.extra.model.sprite.ISpriteDataSource <em>ISprite Data Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>ISprite Data Source</em>'.
	 * @see org.sheepy.lily.vulkan.extra.model.sprite.ISpriteDataSource
	 * @generated
	 */
	EClass getISpriteDataSource();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	SpriteFactory getSpriteFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals
	{
		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.extra.model.sprite.impl.SpriteExtensionImpl <em>Extension</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.extra.model.sprite.impl.SpriteExtensionImpl
		 * @see org.sheepy.lily.vulkan.extra.model.sprite.impl.SpritePackageImpl#getSpriteExtension()
		 * @generated
		 */
		EClass SPRITE_EXTENSION = eINSTANCE.getSpriteExtension();
		/**
		 * The meta object literal for the '<em><b>Draw Task</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SPRITE_EXTENSION__DRAW_TASK = eINSTANCE.getSpriteExtension_DrawTask();
		/**
		 * The meta object literal for the '<em><b>Index Buffer Viewer</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SPRITE_EXTENSION__INDEX_BUFFER_VIEWER = eINSTANCE.getSpriteExtension_IndexBufferViewer();
		/**
		 * The meta object literal for the '<em><b>Vertex Buffer Viewer</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SPRITE_EXTENSION__VERTEX_BUFFER_VIEWER = eINSTANCE.getSpriteExtension_VertexBufferViewer();
		/**
		 * The meta object literal for the '<em><b>Sprites Descriptor</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SPRITE_EXTENSION__SPRITES_DESCRIPTOR = eINSTANCE.getSpriteExtension_SpritesDescriptor();
		/**
		 * The meta object literal for the '<em><b>Sprite Data Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SPRITE_EXTENSION__SPRITE_DATA_SOURCE = eINSTANCE.getSpriteExtension_SpriteDataSource();
		/**
		 * The meta object literal for the '<em><b>Sprite Pipeline Specialization</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SPRITE_EXTENSION__SPRITE_PIPELINE_SPECIALIZATION = eINSTANCE.getSpriteExtension_SpritePipelineSpecialization();
		/**
		 * The meta object literal for the '<em><b>Sprite Image Memory</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SPRITE_EXTENSION__SPRITE_IMAGE_MEMORY = eINSTANCE.getSpriteExtension_SpriteImageMemory();
		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.extra.model.sprite.ISpriteDataSource <em>ISprite Data Source</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.extra.model.sprite.ISpriteDataSource
		 * @see org.sheepy.lily.vulkan.extra.model.sprite.impl.SpritePackageImpl#getISpriteDataSource()
		 * @generated
		 */
		EClass ISPRITE_DATA_SOURCE = eINSTANCE.getISpriteDataSource();

	}

} //SpritePackage
