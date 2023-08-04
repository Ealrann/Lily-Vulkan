/**
 */
package org.sheepy.lily.vulkan.extra.model.rendering.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.sheepy.lily.core.api.model.LilyEObject;
import org.sheepy.lily.vulkan.extra.model.rendering.EPhysicalEntityFeature;
import org.sheepy.lily.vulkan.extra.model.rendering.PhysicalEntity;
import org.sheepy.lily.vulkan.extra.model.rendering.PhysicalEntityVariable;
import org.sheepy.lily.vulkan.extra.model.rendering.RenderingPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Physical Entity Variable</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.rendering.impl.PhysicalEntityVariableImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.rendering.impl.PhysicalEntityVariableImpl#getEntity <em>Entity</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.rendering.impl.PhysicalEntityVariableImpl#getFeature <em>Feature</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PhysicalEntityVariableImpl extends LilyEObject implements PhysicalEntityVariable
{
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getEntity() <em>Entity</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEntity()
	 * @generated
	 * @ordered
	 */
	protected PhysicalEntity entity;

	/**
	 * The default value of the '{@link #getFeature() <em>Feature</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFeature()
	 * @generated
	 * @ordered
	 */
	protected static final EPhysicalEntityFeature FEATURE_EDEFAULT = EPhysicalEntityFeature.LOCATION;

	/**
	 * The cached value of the '{@link #getFeature() <em>Feature</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFeature()
	 * @generated
	 * @ordered
	 */
	protected EPhysicalEntityFeature feature = FEATURE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PhysicalEntityVariableImpl()
	{
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass()
	{
		return RenderingPackage.Literals.PHYSICAL_ENTITY_VARIABLE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getName()
	{
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setName(String newName)
	{
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RenderingPackage.PHYSICAL_ENTITY_VARIABLE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PhysicalEntity getEntity()
	{
		if (entity != null && ((EObject)entity).eIsProxy())
		{
			InternalEObject oldEntity = (InternalEObject)entity;
			entity = (PhysicalEntity)eResolveProxy(oldEntity);
			if (entity != oldEntity)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RenderingPackage.PHYSICAL_ENTITY_VARIABLE__ENTITY, oldEntity, entity));
			}
		}
		return entity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PhysicalEntity basicGetEntity()
	{
		return entity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setEntity(PhysicalEntity newEntity)
	{
		PhysicalEntity oldEntity = entity;
		entity = newEntity;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RenderingPackage.PHYSICAL_ENTITY_VARIABLE__ENTITY, oldEntity, entity));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EPhysicalEntityFeature getFeature()
	{
		return feature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFeature(EPhysicalEntityFeature newFeature)
	{
		EPhysicalEntityFeature oldFeature = feature;
		feature = newFeature == null ? FEATURE_EDEFAULT : newFeature;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RenderingPackage.PHYSICAL_ENTITY_VARIABLE__FEATURE, oldFeature, feature));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType)
	{
		switch (featureID)
		{
			case RenderingPackage.PHYSICAL_ENTITY_VARIABLE__NAME:
				return getName();
			case RenderingPackage.PHYSICAL_ENTITY_VARIABLE__ENTITY:
				if (resolve) return getEntity();
				return basicGetEntity();
			case RenderingPackage.PHYSICAL_ENTITY_VARIABLE__FEATURE:
				return getFeature();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue)
	{
		switch (featureID)
		{
			case RenderingPackage.PHYSICAL_ENTITY_VARIABLE__NAME:
				setName((String)newValue);
				return;
			case RenderingPackage.PHYSICAL_ENTITY_VARIABLE__ENTITY:
				setEntity((PhysicalEntity)newValue);
				return;
			case RenderingPackage.PHYSICAL_ENTITY_VARIABLE__FEATURE:
				setFeature((EPhysicalEntityFeature)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID)
	{
		switch (featureID)
		{
			case RenderingPackage.PHYSICAL_ENTITY_VARIABLE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case RenderingPackage.PHYSICAL_ENTITY_VARIABLE__ENTITY:
				setEntity((PhysicalEntity)null);
				return;
			case RenderingPackage.PHYSICAL_ENTITY_VARIABLE__FEATURE:
				setFeature(FEATURE_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID)
	{
		switch (featureID)
		{
			case RenderingPackage.PHYSICAL_ENTITY_VARIABLE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case RenderingPackage.PHYSICAL_ENTITY_VARIABLE__ENTITY:
				return entity != null;
			case RenderingPackage.PHYSICAL_ENTITY_VARIABLE__FEATURE:
				return feature != FEATURE_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString()
	{
		if (eIsProxy()) return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(", feature: ");
		result.append(feature);
		result.append(')');
		return result.toString();
	}

} //PhysicalEntityVariableImpl
