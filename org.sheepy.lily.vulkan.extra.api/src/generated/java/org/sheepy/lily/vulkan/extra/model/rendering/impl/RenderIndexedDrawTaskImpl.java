/**
 */
package org.sheepy.lily.vulkan.extra.model.rendering.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.sheepy.lily.core.api.model.LilyEObject;

import org.sheepy.lily.vulkan.extra.model.rendering.IndexProvider;
import org.sheepy.lily.vulkan.extra.model.rendering.RenderIndexedDrawTask;
import org.sheepy.lily.vulkan.extra.model.rendering.RenderingPackage;
import org.sheepy.lily.vulkan.extra.model.rendering.Structure;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Render Indexed Draw Task</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.rendering.impl.RenderIndexedDrawTaskImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.rendering.impl.RenderIndexedDrawTaskImpl#isEnabled <em>Enabled</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.rendering.impl.RenderIndexedDrawTaskImpl#getIndexProvider <em>Index Provider</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.rendering.impl.RenderIndexedDrawTaskImpl#getStructure <em>Structure</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RenderIndexedDrawTaskImpl extends LilyEObject implements RenderIndexedDrawTask
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
	 * The cached value of the '{@link #getIndexProvider() <em>Index Provider</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIndexProvider()
	 * @generated
	 * @ordered
	 */
	protected IndexProvider<?> indexProvider;

	/**
	 * The cached value of the '{@link #getStructure() <em>Structure</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStructure()
	 * @generated
	 * @ordered
	 */
	protected Structure structure;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RenderIndexedDrawTaskImpl()
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
		return RenderingPackage.Literals.RENDER_INDEXED_DRAW_TASK;
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
			eNotify(new ENotificationImpl(this, Notification.SET, RenderingPackage.RENDER_INDEXED_DRAW_TASK__NAME, oldName, name));
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
			eNotify(new ENotificationImpl(this, Notification.SET, RenderingPackage.RENDER_INDEXED_DRAW_TASK__ENABLED, oldEnabled, enabled));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IndexProvider<?> getIndexProvider()
	{
		if (indexProvider != null && ((EObject)indexProvider).eIsProxy()) {
			InternalEObject oldIndexProvider = indexProvider;
			indexProvider = (IndexProvider<?>)eResolveProxy(oldIndexProvider);
			if (indexProvider != oldIndexProvider) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RenderingPackage.RENDER_INDEXED_DRAW_TASK__INDEX_PROVIDER, oldIndexProvider, indexProvider));
			}
		}
		return indexProvider;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IndexProvider<?> basicGetIndexProvider()
	{
		return indexProvider;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIndexProvider(IndexProvider<?> newIndexProvider)
	{
		IndexProvider<?> oldIndexProvider = indexProvider;
		indexProvider = newIndexProvider;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RenderingPackage.RENDER_INDEXED_DRAW_TASK__INDEX_PROVIDER, oldIndexProvider, indexProvider));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Structure getStructure()
	{
		if (structure != null && ((EObject)structure).eIsProxy()) {
			InternalEObject oldStructure = structure;
			structure = (Structure)eResolveProxy(oldStructure);
			if (structure != oldStructure) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RenderingPackage.RENDER_INDEXED_DRAW_TASK__STRUCTURE, oldStructure, structure));
			}
		}
		return structure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Structure basicGetStructure()
	{
		return structure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setStructure(Structure newStructure)
	{
		Structure oldStructure = structure;
		structure = newStructure;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RenderingPackage.RENDER_INDEXED_DRAW_TASK__STRUCTURE, oldStructure, structure));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType)
	{
		switch (featureID) {
			case RenderingPackage.RENDER_INDEXED_DRAW_TASK__NAME:
				return getName();
			case RenderingPackage.RENDER_INDEXED_DRAW_TASK__ENABLED:
				return isEnabled();
			case RenderingPackage.RENDER_INDEXED_DRAW_TASK__INDEX_PROVIDER:
				if (resolve) return getIndexProvider();
				return basicGetIndexProvider();
			case RenderingPackage.RENDER_INDEXED_DRAW_TASK__STRUCTURE:
				if (resolve) return getStructure();
				return basicGetStructure();
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
		switch (featureID) {
			case RenderingPackage.RENDER_INDEXED_DRAW_TASK__NAME:
				setName((String)newValue);
				return;
			case RenderingPackage.RENDER_INDEXED_DRAW_TASK__ENABLED:
				setEnabled((Boolean)newValue);
				return;
			case RenderingPackage.RENDER_INDEXED_DRAW_TASK__INDEX_PROVIDER:
				setIndexProvider((IndexProvider<?>)newValue);
				return;
			case RenderingPackage.RENDER_INDEXED_DRAW_TASK__STRUCTURE:
				setStructure((Structure)newValue);
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
		switch (featureID) {
			case RenderingPackage.RENDER_INDEXED_DRAW_TASK__NAME:
				setName(NAME_EDEFAULT);
				return;
			case RenderingPackage.RENDER_INDEXED_DRAW_TASK__ENABLED:
				setEnabled(ENABLED_EDEFAULT);
				return;
			case RenderingPackage.RENDER_INDEXED_DRAW_TASK__INDEX_PROVIDER:
				setIndexProvider((IndexProvider<?>)null);
				return;
			case RenderingPackage.RENDER_INDEXED_DRAW_TASK__STRUCTURE:
				setStructure((Structure)null);
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
		switch (featureID) {
			case RenderingPackage.RENDER_INDEXED_DRAW_TASK__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case RenderingPackage.RENDER_INDEXED_DRAW_TASK__ENABLED:
				return enabled != ENABLED_EDEFAULT;
			case RenderingPackage.RENDER_INDEXED_DRAW_TASK__INDEX_PROVIDER:
				return indexProvider != null;
			case RenderingPackage.RENDER_INDEXED_DRAW_TASK__STRUCTURE:
				return structure != null;
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

} //RenderIndexedDrawTaskImpl
