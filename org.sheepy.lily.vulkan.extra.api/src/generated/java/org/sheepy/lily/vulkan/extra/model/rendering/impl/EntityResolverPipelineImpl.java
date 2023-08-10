/**
 */
package org.sheepy.lily.vulkan.extra.model.rendering.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.sheepy.lily.core.api.model.LilyEObject;
import org.sheepy.lily.vulkan.extra.model.rendering.EntityResolverPipeline;
import org.sheepy.lily.vulkan.extra.model.rendering.IEntityResolver;
import org.sheepy.lily.vulkan.extra.model.rendering.RenderingPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Entity Resolver Pipeline</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.rendering.impl.EntityResolverPipelineImpl#getEntityResolvers <em>Entity Resolvers</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.rendering.impl.EntityResolverPipelineImpl#isTakeFirst <em>Take First</em>}</li>
 * </ul>
 *
 * @generated
 */
public class EntityResolverPipelineImpl extends LilyEObject implements EntityResolverPipeline
{
	/**
	 * The cached value of the '{@link #getEntityResolvers() <em>Entity Resolvers</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEntityResolvers()
	 * @generated
	 * @ordered
	 */
	protected EList<IEntityResolver> entityResolvers;

	/**
	 * The default value of the '{@link #isTakeFirst() <em>Take First</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isTakeFirst()
	 * @generated
	 * @ordered
	 */
	protected static final boolean TAKE_FIRST_EDEFAULT = false;
	/**
	 * The cached value of the '{@link #isTakeFirst() <em>Take First</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isTakeFirst()
	 * @generated
	 * @ordered
	 */
	protected boolean takeFirst = TAKE_FIRST_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EntityResolverPipelineImpl()
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
		return RenderingPackage.Literals.ENTITY_RESOLVER_PIPELINE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<IEntityResolver> getEntityResolvers()
	{
		if (entityResolvers == null)
		{
			entityResolvers = new EObjectResolvingEList<>(IEntityResolver.class, this, RenderingPackage.ENTITY_RESOLVER_PIPELINE__ENTITY_RESOLVERS);
		}
		return entityResolvers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isTakeFirst()
	{
		return takeFirst;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTakeFirst(boolean newTakeFirst)
	{
		boolean oldTakeFirst = takeFirst;
		takeFirst = newTakeFirst;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RenderingPackage.ENTITY_RESOLVER_PIPELINE__TAKE_FIRST, oldTakeFirst, takeFirst));
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
			case RenderingPackage.ENTITY_RESOLVER_PIPELINE__ENTITY_RESOLVERS:
				return getEntityResolvers();
			case RenderingPackage.ENTITY_RESOLVER_PIPELINE__TAKE_FIRST:
				return isTakeFirst();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue)
	{
		switch (featureID)
		{
			case RenderingPackage.ENTITY_RESOLVER_PIPELINE__ENTITY_RESOLVERS:
				getEntityResolvers().clear();
				getEntityResolvers().addAll((Collection<? extends IEntityResolver>)newValue);
				return;
			case RenderingPackage.ENTITY_RESOLVER_PIPELINE__TAKE_FIRST:
				setTakeFirst((Boolean)newValue);
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
			case RenderingPackage.ENTITY_RESOLVER_PIPELINE__ENTITY_RESOLVERS:
				getEntityResolvers().clear();
				return;
			case RenderingPackage.ENTITY_RESOLVER_PIPELINE__TAKE_FIRST:
				setTakeFirst(TAKE_FIRST_EDEFAULT);
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
			case RenderingPackage.ENTITY_RESOLVER_PIPELINE__ENTITY_RESOLVERS:
				return entityResolvers != null && !entityResolvers.isEmpty();
			case RenderingPackage.ENTITY_RESOLVER_PIPELINE__TAKE_FIRST:
				return takeFirst != TAKE_FIRST_EDEFAULT;
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
		result.append(" (takeFirst: ");
		result.append(takeFirst);
		result.append(')');
		return result.toString();
	}

} //EntityResolverPipelineImpl
