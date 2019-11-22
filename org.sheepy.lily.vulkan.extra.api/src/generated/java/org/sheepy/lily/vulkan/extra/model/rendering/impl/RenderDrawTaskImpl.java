/**
 */
package org.sheepy.lily.vulkan.extra.model.rendering.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.sheepy.lily.core.api.adapter.LilyEObject;

import org.sheepy.lily.vulkan.extra.model.rendering.RenderDrawTask;
import org.sheepy.lily.vulkan.extra.model.rendering.RenderingPackage;
import org.sheepy.lily.vulkan.extra.model.rendering.VertexProvider;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Render Draw Task</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.rendering.impl.RenderDrawTaskImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.rendering.impl.RenderDrawTaskImpl#isEnabled <em>Enabled</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.rendering.impl.RenderDrawTaskImpl#getVertexProviders <em>Vertex Providers</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RenderDrawTaskImpl extends LilyEObject implements RenderDrawTask
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
	 * The default value of the '{@link #isEnabled() <em>Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnabled()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ENABLED_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isEnabled() <em>Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnabled()
	 * @generated
	 * @ordered
	 */
	protected boolean enabled = ENABLED_EDEFAULT;

	/**
	 * The cached value of the '{@link #getVertexProviders() <em>Vertex Providers</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVertexProviders()
	 * @generated
	 * @ordered
	 */
	protected EList<VertexProvider<?>> vertexProviders;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RenderDrawTaskImpl()
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
		return RenderingPackage.Literals.RENDER_DRAW_TASK;
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
			eNotify(new ENotificationImpl(this, Notification.SET, RenderingPackage.RENDER_DRAW_TASK__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isEnabled()
	{
		return enabled;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setEnabled(boolean newEnabled)
	{
		boolean oldEnabled = enabled;
		enabled = newEnabled;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RenderingPackage.RENDER_DRAW_TASK__ENABLED, oldEnabled, enabled));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<VertexProvider<?>> getVertexProviders()
	{
		if (vertexProviders == null)
		{
			vertexProviders = new EObjectResolvingEList<VertexProvider<?>>(VertexProvider.class, this, RenderingPackage.RENDER_DRAW_TASK__VERTEX_PROVIDERS);
		}
		return vertexProviders;
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
			case RenderingPackage.RENDER_DRAW_TASK__NAME:
				return getName();
			case RenderingPackage.RENDER_DRAW_TASK__ENABLED:
				return isEnabled();
			case RenderingPackage.RENDER_DRAW_TASK__VERTEX_PROVIDERS:
				return getVertexProviders();
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
			case RenderingPackage.RENDER_DRAW_TASK__NAME:
				setName((String)newValue);
				return;
			case RenderingPackage.RENDER_DRAW_TASK__ENABLED:
				setEnabled((Boolean)newValue);
				return;
			case RenderingPackage.RENDER_DRAW_TASK__VERTEX_PROVIDERS:
				getVertexProviders().clear();
				getVertexProviders().addAll((Collection<? extends VertexProvider<?>>)newValue);
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
			case RenderingPackage.RENDER_DRAW_TASK__NAME:
				setName(NAME_EDEFAULT);
				return;
			case RenderingPackage.RENDER_DRAW_TASK__ENABLED:
				setEnabled(ENABLED_EDEFAULT);
				return;
			case RenderingPackage.RENDER_DRAW_TASK__VERTEX_PROVIDERS:
				getVertexProviders().clear();
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
			case RenderingPackage.RENDER_DRAW_TASK__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case RenderingPackage.RENDER_DRAW_TASK__ENABLED:
				return enabled != ENABLED_EDEFAULT;
			case RenderingPackage.RENDER_DRAW_TASK__VERTEX_PROVIDERS:
				return vertexProviders != null && !vertexProviders.isEmpty();
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
		result.append(", enabled: ");
		result.append(enabled);
		result.append(')');
		return result.toString();
	}

} //RenderDrawTaskImpl
