/**
 */
package org.sheepy.lily.vulkan.extra.model.rendering;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.sheepy.lily.core.model.types.TypesPackage;

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
 * @see org.sheepy.lily.vulkan.extra.model.rendering.RenderingFactory
 * @model kind="package"
 * @generated
 */
public interface RenderingPackage extends EPackage
{
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "rendering";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "org.sheepy.lily.vulkan.extra.model.rendering";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "rendering";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	RenderingPackage eINSTANCE = org.sheepy.lily.vulkan.extra.model.rendering.impl.RenderingPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.extra.model.rendering.Entity <em>Entity</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.Entity
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.impl.RenderingPackageImpl#getEntity()
	 * @generated
	 */
	int ENTITY = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY__NAME = TypesPackage.LNAMED_ELEMENT__NAME;

	/**
	 * The number of structural features of the '<em>Entity</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_FEATURE_COUNT = TypesPackage.LNAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.extra.model.rendering.impl.PhysicalEntityImpl <em>Physical Entity</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.impl.PhysicalEntityImpl
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.impl.RenderingPackageImpl#getPhysicalEntity()
	 * @generated
	 */
	int PHYSICAL_ENTITY = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PHYSICAL_ENTITY__NAME = ENTITY__NAME;

	/**
	 * The feature id for the '<em><b>Geo Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PHYSICAL_ENTITY__GEO_LOCATION = ENTITY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Geo Orientation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PHYSICAL_ENTITY__GEO_ORIENTATION = ENTITY_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Axis Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PHYSICAL_ENTITY__AXIS_LOCATION = ENTITY_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Axis</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PHYSICAL_ENTITY__AXIS = ENTITY_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Physical Entity</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PHYSICAL_ENTITY_FEATURE_COUNT = ENTITY_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.extra.model.rendering.impl.AxisImpl <em>Axis</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.impl.AxisImpl
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.impl.RenderingPackageImpl#getAxis()
	 * @generated
	 */
	int AXIS = 2;

	/**
	 * The feature id for the '<em><b>Front Direction</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AXIS__FRONT_DIRECTION = 0;

	/**
	 * The feature id for the '<em><b>Up Direction</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AXIS__UP_DIRECTION = 1;

	/**
	 * The feature id for the '<em><b>Right Direction</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AXIS__RIGHT_DIRECTION = 2;

	/**
	 * The number of structural features of the '<em>Axis</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AXIS_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.extra.model.rendering.Presentation <em>Presentation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.Presentation
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.impl.RenderingPackageImpl#getPresentation()
	 * @generated
	 */
	int PRESENTATION = 3;

	/**
	 * The feature id for the '<em><b>Presented Entities</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRESENTATION__PRESENTED_ENTITIES = 0;

	/**
	 * The number of structural features of the '<em>Presentation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRESENTATION_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.extra.model.rendering.impl.PresentationPkgImpl <em>Presentation Pkg</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.impl.PresentationPkgImpl
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.impl.RenderingPackageImpl#getPresentationPkg()
	 * @generated
	 */
	int PRESENTATION_PKG = 4;

	/**
	 * The feature id for the '<em><b>Presentations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRESENTATION_PKG__PRESENTATIONS = 0;

	/**
	 * The number of structural features of the '<em>Presentation Pkg</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRESENTATION_PKG_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.extra.model.rendering.impl.PresentableEntityImpl <em>Presentable Entity</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.impl.PresentableEntityImpl
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.impl.RenderingPackageImpl#getPresentableEntity()
	 * @generated
	 */
	int PRESENTABLE_ENTITY = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRESENTABLE_ENTITY__NAME = PHYSICAL_ENTITY__NAME;

	/**
	 * The feature id for the '<em><b>Geo Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRESENTABLE_ENTITY__GEO_LOCATION = PHYSICAL_ENTITY__GEO_LOCATION;

	/**
	 * The feature id for the '<em><b>Geo Orientation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRESENTABLE_ENTITY__GEO_ORIENTATION = PHYSICAL_ENTITY__GEO_ORIENTATION;

	/**
	 * The feature id for the '<em><b>Axis Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRESENTABLE_ENTITY__AXIS_LOCATION = PHYSICAL_ENTITY__AXIS_LOCATION;

	/**
	 * The feature id for the '<em><b>Axis</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRESENTABLE_ENTITY__AXIS = PHYSICAL_ENTITY__AXIS;

	/**
	 * The feature id for the '<em><b>Presentation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRESENTABLE_ENTITY__PRESENTATION = PHYSICAL_ENTITY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Scale</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRESENTABLE_ENTITY__SCALE = PHYSICAL_ENTITY_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Presentable Entity</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRESENTABLE_ENTITY_FEATURE_COUNT = PHYSICAL_ENTITY_FEATURE_COUNT + 2;


	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.extra.model.rendering.Entity <em>Entity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Entity</em>'.
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.Entity
	 * @generated
	 */
	EClass getEntity();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.extra.model.rendering.PhysicalEntity <em>Physical Entity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Physical Entity</em>'.
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.PhysicalEntity
	 * @generated
	 */
	EClass getPhysicalEntity();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.extra.model.rendering.PhysicalEntity#getGeoLocation <em>Geo Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Geo Location</em>'.
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.PhysicalEntity#getGeoLocation()
	 * @see #getPhysicalEntity()
	 * @generated
	 */
	EAttribute getPhysicalEntity_GeoLocation();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.extra.model.rendering.PhysicalEntity#getGeoOrientation <em>Geo Orientation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Geo Orientation</em>'.
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.PhysicalEntity#getGeoOrientation()
	 * @see #getPhysicalEntity()
	 * @generated
	 */
	EAttribute getPhysicalEntity_GeoOrientation();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.extra.model.rendering.PhysicalEntity#getAxisLocation <em>Axis Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Axis Location</em>'.
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.PhysicalEntity#getAxisLocation()
	 * @see #getPhysicalEntity()
	 * @generated
	 */
	EAttribute getPhysicalEntity_AxisLocation();

	/**
	 * Returns the meta object for the containment reference '{@link org.sheepy.lily.vulkan.extra.model.rendering.PhysicalEntity#getAxis <em>Axis</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Axis</em>'.
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.PhysicalEntity#getAxis()
	 * @see #getPhysicalEntity()
	 * @generated
	 */
	EReference getPhysicalEntity_Axis();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.extra.model.rendering.Axis <em>Axis</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Axis</em>'.
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.Axis
	 * @generated
	 */
	EClass getAxis();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.extra.model.rendering.Axis#getFrontDirection <em>Front Direction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Front Direction</em>'.
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.Axis#getFrontDirection()
	 * @see #getAxis()
	 * @generated
	 */
	EAttribute getAxis_FrontDirection();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.extra.model.rendering.Axis#getUpDirection <em>Up Direction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Up Direction</em>'.
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.Axis#getUpDirection()
	 * @see #getAxis()
	 * @generated
	 */
	EAttribute getAxis_UpDirection();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.extra.model.rendering.Axis#getRightDirection <em>Right Direction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Right Direction</em>'.
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.Axis#getRightDirection()
	 * @see #getAxis()
	 * @generated
	 */
	EAttribute getAxis_RightDirection();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.extra.model.rendering.Presentation <em>Presentation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Presentation</em>'.
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.Presentation
	 * @generated
	 */
	EClass getPresentation();

	/**
	 * Returns the meta object for the reference list '{@link org.sheepy.lily.vulkan.extra.model.rendering.Presentation#getPresentedEntities <em>Presented Entities</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Presented Entities</em>'.
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.Presentation#getPresentedEntities()
	 * @see #getPresentation()
	 * @generated
	 */
	EReference getPresentation_PresentedEntities();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.extra.model.rendering.PresentationPkg <em>Presentation Pkg</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Presentation Pkg</em>'.
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.PresentationPkg
	 * @generated
	 */
	EClass getPresentationPkg();

	/**
	 * Returns the meta object for the containment reference list '{@link org.sheepy.lily.vulkan.extra.model.rendering.PresentationPkg#getPresentations <em>Presentations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Presentations</em>'.
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.PresentationPkg#getPresentations()
	 * @see #getPresentationPkg()
	 * @generated
	 */
	EReference getPresentationPkg_Presentations();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.extra.model.rendering.PresentableEntity <em>Presentable Entity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Presentable Entity</em>'.
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.PresentableEntity
	 * @generated
	 */
	EClass getPresentableEntity();

	/**
	 * Returns the meta object for the reference '{@link org.sheepy.lily.vulkan.extra.model.rendering.PresentableEntity#getPresentation <em>Presentation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Presentation</em>'.
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.PresentableEntity#getPresentation()
	 * @see #getPresentableEntity()
	 * @generated
	 */
	EReference getPresentableEntity_Presentation();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.extra.model.rendering.PresentableEntity#getScale <em>Scale</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Scale</em>'.
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.PresentableEntity#getScale()
	 * @see #getPresentableEntity()
	 * @generated
	 */
	EAttribute getPresentableEntity_Scale();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	RenderingFactory getRenderingFactory();

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
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.extra.model.rendering.Entity <em>Entity</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.extra.model.rendering.Entity
		 * @see org.sheepy.lily.vulkan.extra.model.rendering.impl.RenderingPackageImpl#getEntity()
		 * @generated
		 */
		EClass ENTITY = eINSTANCE.getEntity();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.extra.model.rendering.impl.PhysicalEntityImpl <em>Physical Entity</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.extra.model.rendering.impl.PhysicalEntityImpl
		 * @see org.sheepy.lily.vulkan.extra.model.rendering.impl.RenderingPackageImpl#getPhysicalEntity()
		 * @generated
		 */
		EClass PHYSICAL_ENTITY = eINSTANCE.getPhysicalEntity();

		/**
		 * The meta object literal for the '<em><b>Geo Location</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PHYSICAL_ENTITY__GEO_LOCATION = eINSTANCE.getPhysicalEntity_GeoLocation();

		/**
		 * The meta object literal for the '<em><b>Geo Orientation</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PHYSICAL_ENTITY__GEO_ORIENTATION = eINSTANCE.getPhysicalEntity_GeoOrientation();

		/**
		 * The meta object literal for the '<em><b>Axis Location</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PHYSICAL_ENTITY__AXIS_LOCATION = eINSTANCE.getPhysicalEntity_AxisLocation();

		/**
		 * The meta object literal for the '<em><b>Axis</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PHYSICAL_ENTITY__AXIS = eINSTANCE.getPhysicalEntity_Axis();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.extra.model.rendering.impl.AxisImpl <em>Axis</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.extra.model.rendering.impl.AxisImpl
		 * @see org.sheepy.lily.vulkan.extra.model.rendering.impl.RenderingPackageImpl#getAxis()
		 * @generated
		 */
		EClass AXIS = eINSTANCE.getAxis();

		/**
		 * The meta object literal for the '<em><b>Front Direction</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AXIS__FRONT_DIRECTION = eINSTANCE.getAxis_FrontDirection();

		/**
		 * The meta object literal for the '<em><b>Up Direction</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AXIS__UP_DIRECTION = eINSTANCE.getAxis_UpDirection();

		/**
		 * The meta object literal for the '<em><b>Right Direction</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AXIS__RIGHT_DIRECTION = eINSTANCE.getAxis_RightDirection();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.extra.model.rendering.Presentation <em>Presentation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.extra.model.rendering.Presentation
		 * @see org.sheepy.lily.vulkan.extra.model.rendering.impl.RenderingPackageImpl#getPresentation()
		 * @generated
		 */
		EClass PRESENTATION = eINSTANCE.getPresentation();

		/**
		 * The meta object literal for the '<em><b>Presented Entities</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PRESENTATION__PRESENTED_ENTITIES = eINSTANCE.getPresentation_PresentedEntities();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.extra.model.rendering.impl.PresentationPkgImpl <em>Presentation Pkg</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.extra.model.rendering.impl.PresentationPkgImpl
		 * @see org.sheepy.lily.vulkan.extra.model.rendering.impl.RenderingPackageImpl#getPresentationPkg()
		 * @generated
		 */
		EClass PRESENTATION_PKG = eINSTANCE.getPresentationPkg();

		/**
		 * The meta object literal for the '<em><b>Presentations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PRESENTATION_PKG__PRESENTATIONS = eINSTANCE.getPresentationPkg_Presentations();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.extra.model.rendering.impl.PresentableEntityImpl <em>Presentable Entity</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.extra.model.rendering.impl.PresentableEntityImpl
		 * @see org.sheepy.lily.vulkan.extra.model.rendering.impl.RenderingPackageImpl#getPresentableEntity()
		 * @generated
		 */
		EClass PRESENTABLE_ENTITY = eINSTANCE.getPresentableEntity();

		/**
		 * The meta object literal for the '<em><b>Presentation</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PRESENTABLE_ENTITY__PRESENTATION = eINSTANCE.getPresentableEntity_Presentation();

		/**
		 * The meta object literal for the '<em><b>Scale</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PRESENTABLE_ENTITY__SCALE = eINSTANCE.getPresentableEntity_Scale();

	}

} //RenderingPackage
